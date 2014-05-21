package com.ardublock.translator.block.sawersbot;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class UltrasonicoBlock extends TranslatorBlock {

  public UltrasonicoBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
    super(blockId, translator, codePrefix, codeSuffix, label);

  }

  @Override
  public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
    SawersBotUtil.setupWire( translator );

    translator.addDefinitionCommand("int readDistance()\n" +
                                    "{\n" +
                                    "    int c;\n" +
                                    "    Wire.requestFrom( 2 , 1 );\n" +
                                    "\n" +
                                    "    while( Wire.available() )\n" +
                                    "    { \n" +
                                    "        c = Wire.read();\n" +
                                    "    }\n" +
                                    "    return c;\n" +
                                    "}" );
    
    return codePrefix + " readDistance() " + codeSuffix ;
  }
  
}
