package com.ardublock.translator.block;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class EqualPolyBlock extends TranslatorBlock
{
	public EqualPolyBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		String ret = "( ( ";
		TranslatorBlock tb = this.getRequiredTranslatorBlockAtSocket(0);
		ret = ret + tb.toCode();
		tb = this.getRequiredTranslatorBlockAtSocket(1);
        if ( tb.toCode().length() == 3 ) {
            ret = ret + " ) == (\'";
    		ret = ret + tb.toCode().replace("\"","");
    		ret = ret + "\') )";
        } else{
            ret +=  " ) == ( ";
            ret +=  tb.toCode();
    		ret +=  " ) )";
        }
		return codePrefix + ret + codeSuffix;
	}
}
