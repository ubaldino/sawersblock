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

    translator.addDefinitionCommand("int reflectivo[] = new int( 5 ) ;") ;
    
    translator.addSetupCommand("pinMode ( led , OUTPUT ) ;");
    
    
    TranslatorBlock tb = this.getRequiredTranslatorBlockAtSocket( 0 );
    //secuencia = String.format( secuencia , tb.toCode() , tb.toCode() ) ;
    
    return "A"+ ( Integer.parseInt( tb.toCode() )-1 );
  }
}
