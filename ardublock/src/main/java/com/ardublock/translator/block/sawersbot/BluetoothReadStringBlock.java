
package com.ardublock.translator.block.sawersbot;
import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

/**
 * @author ubaldino
 */
public class BluetoothReadStringBlock extends TranslatorBlock
{
	public BluetoothReadStringBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
		SawersBotUtil.setupSerial1(translator);

        translator.addDefinitionCommand(
                  "String bluetoothString()"
                + "{\n"
                + "  String cadena = \"\";\n"
                + "    while( Serial1.available() )"
                + "    {\n"
                + "      cadena += char( Serial1.read() );\n"
                + "      delay( 3 );\n"
                + "    }\n"
                + "  return cadena;\n"
                + "}");
        
		String ret = "bluetoothString()";
		return codePrefix + ret + codeSuffix;
	}
}