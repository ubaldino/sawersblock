package com.ardublock.translator.block.sawersbot;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

/**
 *
 * @author ubaldino
 */
public class PulsadorBlock extends TranslatorBlock {

  public PulsadorBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
    super(blockId, translator, codePrefix, codeSuffix, label);
  }

  @Override
  public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
    
    translator.addSetupCommand( "pinMode( 4 , INPUT );" );
    String ret = "digitalRead( 4 );";
    return ret;
  }
}