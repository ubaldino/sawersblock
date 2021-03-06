package com.ardublock.translator.block.sawersbot;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class ReflectivoBlock extends TranslatorBlock {

  public ReflectivoBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
    super(blockId, translator, codePrefix, codeSuffix, label);
  }

  @Override
  public String toCode() throws SocketNullException, SubroutineNotDeclaredException {

    SawersBotUtil.setupWire( translator );
    
    translator.addDefinitionCommand("int getSensorState( int pos )\n" +
                                    "{\n" +
                                    "    byte sensL[4];\n" +
                                    "    int c;\n" +
                                    "    int count=0;\n" +
                                    "    Wire.requestFrom( 3 , 4 );\n" +
                                    "    while( Wire.available() )\n" +
                                    "    {\n" +
                                    "        c = Wire.read();\n" +
                                    "        sensL[ count ]=c;\n" +
                                    "        count++;\n" +
                                    "    }\n" +
                                    "    return( sensL[ pos ] );\n" +
                                    "}" );
    
    TranslatorBlock tb = this.getRequiredTranslatorBlockAtSocket( 0 );
    //secuencia = String.format( secuencia , tb.toCode() , tb.toCode() ) ;
    
    return  codePrefix + " getSensorState( " +( Integer.parseInt( tb.toCode() )-1 ) + " ) "  + codeSuffix;
  }
}
