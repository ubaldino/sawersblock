package com.ardublock.translator.block.sawersbot;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class BocinaBlock extends TranslatorBlock {

  public BocinaBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
    super( blockId , translator , codePrefix , codeSuffix , label );
  }

  @Override
  public String toCode() throws SocketNullException, SubroutineNotDeclaredException {

    TranslatorBlock freqBlock = this.getRequiredTranslatorBlockAtSocket( 0 );

    String ret = "tone( 5 , " + freqBlock.toCode() + ");\n";
    return ret;
  }
}
