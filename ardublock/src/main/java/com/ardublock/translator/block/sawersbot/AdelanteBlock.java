package com.ardublock.translator.block.sawersbot;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;
public class AdelanteBlock extends TranslatorBlock {

    public AdelanteBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
        super(blockId, translator, codePrefix, codeSuffix, label);
    }

    @Override
    public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
        
        SawersBotUtil.setupServosRueda(translator);
        int servo_inicial = 90;

        String secuencia = "servo_pin_8.attach( 8 );\nservo_pin_9.attach( 9 );\n";
        String servo_8 = "servo_pin_8.write( "; 
        String servo_9 = "servo_pin_9.write( ";
        
        String valor = this.getRequiredTranslatorBlockAtSocket( 0 ).toCode();
        
        if ( SawersBotUtil.isNumeric( valor ) ) {
            servo_8 += servo_inicial + Integer.parseInt( valor );
            servo_9 += servo_inicial - Integer.parseInt( valor );
        } else {
            servo_8 += servo_inicial + " + " + valor;
            servo_9 += servo_inicial + " - " + valor;
        }
        
        servo_8 += " + " + this.getRequiredTranslatorBlockAtSocket( 1 ).toCode() + " );\n";
        servo_9 += " - " + this.getRequiredTranslatorBlockAtSocket( 2 ).toCode() + " );\n";
        
        secuencia += servo_8 + servo_9 ;
        return codePrefix + secuencia + codeSuffix + "\n";
    }
}
