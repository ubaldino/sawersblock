
package com.ardublock.translator.block.sawersbot;
import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

/**
 * @author ubaldino
 */
public class BluetoothFlushBlock extends TranslatorBlock
{
	public BluetoothFlushBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
		SawersBotUtil.setupSerial1(translator);

		return "Serial1.flush();\n";
	}
}