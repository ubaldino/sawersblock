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
    //SawersBotUtil.setupEnv(translator);
    translator.addHeaderFile("Ultrasonic.h");
    translator.addDefinitionCommand("Ultrasonic ultrasonic( 5 , 12 );");
    return "ultrasonic.Ranging( CM )";
  }

}
