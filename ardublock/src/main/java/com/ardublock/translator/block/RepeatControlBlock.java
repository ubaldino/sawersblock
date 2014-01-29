package com.ardublock.translator.block;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class RepeatControlBlock extends TranslatorBlock
{

	public RepeatControlBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator);
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
	    int start=0, stop=0;
	    String aux;
		String varName="";//this.getRequiredTranslatorBlockAtSocket(0);
		TranslatorBlock teste = this.getRequiredTranslatorBlockAtSocket(0);
		varName=varName+teste.toCode();
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
		String ret = "for (" + varName + "= (";
		start=Integer.parseInt(translatorBlock.toCode());
		ret = ret + String.valueOf(start) + ") ; ";
		translatorBlock = this.getRequiredTranslatorBlockAtSocket(2);
		stop=Integer.parseInt(translatorBlock.toCode());
		if(stop>=start){
		    ret = ret + varName + " <= (";
		    ret = ret + String.valueOf(stop) + ") ; "+varName + "+= (";
		    translatorBlock = this.getRequiredTranslatorBlockAtSocket(3);
		    ret = ret + translatorBlock.toCode() +") )\n{\n";
		}else{
		    ret = ret + varName + " >= (";
		    ret = ret + String.valueOf(stop) + ") ; "+varName + "-= (";
		    translatorBlock = this.getRequiredTranslatorBlockAtSocket(3);
		    ret = ret + translatorBlock.toCode() +") )\n{\n";
		}
		translatorBlock = getTranslatorBlockAtSocket(4);
		while (translatorBlock != null)
		{
			ret = ret + translatorBlock.toCode();
			translatorBlock = translatorBlock.nextTranslatorBlock();
		}
		
		ret = ret + "}\n";
		return ret;
	}

}
