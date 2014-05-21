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
    
    TranslatorBlock tb = this.getRequiredTranslatorBlockAtSocket( 0 );
    
    String valor = ( tb.toCode().equals( "LOW" ) )? "LOW" : "HIGH" ;
    String secuencia = "digitalWrite( led ,%s );";

    secuencia = String.format( secuencia , valor ) ;
    return secuencia;
  }
}
