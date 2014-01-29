package com.ardublock.translator.block.sawersbot;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class LedBlock extends TranslatorBlock {

  public LedBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
    super(blockId, translator, codePrefix, codeSuffix, label);
  }

  @Override
  public String toCode() throws SocketNullException, SubroutineNotDeclaredException {

    translator.addDefinitionCommand("int led = 13 ;") ;
    translator.addSetupCommand("pinMode ( led , OUTPUT ) ;");
    
    String secuencia = "digitalWrite( led , HIGH ); \n delay( %s );"
            + " \n digitalWrite( led , LOW ); \n delay( %s );";
    
    TranslatorBlock tb = this.getRequiredTranslatorBlockAtSocket( 0 );
    secuencia = String.format( secuencia , tb.toCode() , tb.toCode() ) ;
    
    return secuencia;
  }
}
