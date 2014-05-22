/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ardublock.translator.block.sawersbot;

/**
 *
 * @author ubaldino
 */
import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class BluetoothPrintBlock extends TranslatorBlock {
	public BluetoothPrintBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
		
      SawersBotUtil.setupSerial1(translator);
      
      TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket( 0 , "Serial1.print( " , " );\n" );
		
      String ret = translatorBlock.toCode();
      translatorBlock = this.getRequiredTranslatorBlockAtSocket( 1 );
      String test=translatorBlock.toCode();
      //		ret+=test;

      if( test.equals("si") ){
          ret += "Serial1.println();\n";
      }

      return ret;
	}
}