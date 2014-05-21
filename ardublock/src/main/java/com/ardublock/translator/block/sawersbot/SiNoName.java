package com.ardublock.translator.block.sawersbot;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

/**
 *
 * @author ubaldino
 */

public class SiNoName extends TranslatorBlock {

  public SiNoName(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
    super(blockId, translator, codePrefix, codeSuffix, label);
  }

  @Override
  public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
    String name = this.getTranslator().getBlock(blockId).getGenusName();
    String name_str = name.split("_")[1];
    return name_str;
  }
}
