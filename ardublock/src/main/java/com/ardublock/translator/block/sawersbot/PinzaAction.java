package com.ardublock.translator.block.sawersbot;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class PinzaAction extends TranslatorBlock {

  public PinzaAction(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
    super(blockId, translator, codePrefix, codeSuffix, label);
  }

  @Override
  public String toCode() throws SocketNullException, SubroutineNotDeclaredException {

    String action = this.getTranslator().getBlock(blockId).getGenusName();
    String action_str = action.split("_")[2];
    //System.out.println(action_str);
    return action_str;

  }
}
