package com.ardublock.translator.block.sawersbot;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class PinzaBlock extends TranslatorBlock {

  public PinzaBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
    super(blockId, translator, codePrefix, codeSuffix, label);

  }

  @Override
  public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
    //SawersBotUtil.setupEnv(translator);
    translator.addHeaderFile("Servo.h");
    translator.addDefinitionCommand("Servo servo_pin_7;");
    translator.addSetupCommand("servo_pin_7.attach( 7 );");
    
    TranslatorBlock tb =  this.getRequiredTranslatorBlockAtSocket( 1 ) ;
    int valor_porcentual =  Integer.parseInt( tb.toCode() );

    tb = this.getRequiredTranslatorBlockAtSocket( 0 );
    
    float paso;
    
    if ( tb.toCode().equals( "cerrar" ) )
            //paso = ( 90 * ( valor_porcentual / (float)100  ) ) ;
        paso = ( 50 ) ;
    else
      //paso = ( 90 - ( 90 * ( valor_porcentual / (float)100  ) ) ) ;
      paso = ( 175 ) ;
    //String secuencia = "servo_pin_7.write( " + (int)Math.round( paso ) + " );\nservo_pin_7.detach();\n";
    String secuencia = "servo_pin_7.write( " + (int)Math.round( paso ) + " );\n";
    return codePrefix + secuencia + codeSuffix;
  }

}
