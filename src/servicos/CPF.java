package servicos;

import interfaces.IValidarDocumento;

public class CPF implements IValidarDocumento {

    @Override
    public boolean validar(String doc) {

        String _cpf = formatarSemPontos(doc);

        if(_cpf.equals("00000000000") ||
                _cpf.equals("11111111111")||
                _cpf.equals("22222222222")||
                _cpf.equals("33333333333")||
                _cpf.equals("44444444444")||
                _cpf.equals("55555555555")||
                _cpf.equals("66666666666")||
                _cpf.equals("77777777777")||
                _cpf.equals("88888888888")||
                _cpf.equals("99999999999")||

                (_cpf.length()!=11)) {
            return false;
        }
        
        int total = 0; //Recebe o total da soma dos digitos do CPF multiplicaod pelo peso
        int peso = 10; //Diminui pra cada digito do CPF
        int num = 0; //Recebe o digito convertido de String para int
        int digVerificador = 0; //Recebe o calculo do digito verificador
        int dig10 = 0; //Primeiro digito verificador
        int dig11 = 0; //Segundo digito verificador
            
        //Calculo do primeiro digito verificador
        for (int i = 0; i < 9; i++){
            String digito =  _cpf.substring(i, i+1);
            num = Integer.parseInt(digito);
            total += (num * peso);
            peso -= 1;
        }
            
        digVerificador = 11 - (total % 11);
        if ((digVerificador == 10) || (digVerificador == 11)){
            dig10 = 0;                
        } else{
            dig10 = digVerificador;
        }
        
        //Calculo do segundo digito verificador
        total = 0;
        peso = 11;
        for(int i = 0; i < 10; i++){
            String digito = _cpf.substring(i, i+1);
            num = Integer.parseInt(digito);
            total += (num * peso);
            peso -= 1;
        }
        
        digVerificador = 11 - (total % 11);
        if((digVerificador == 10) || (digVerificador == 11)){
            dig11 = 0;
        } else {
            dig11 = digVerificador;
        }

        String _dig1 = _cpf.substring(9, 10);
        String _dig2 = _cpf.substring(10, 11);

        int _dig10 = Integer.parseInt(_dig1);
        int _dig11 = Integer.parseInt(_dig2);

        //Verfica se os digitos calculados conferem com os digitos informados
        if((dig10 == _dig10) &&
                (dig11 == _dig11)){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String formatarSemPontos(String doc){
        String _cpf = doc.replace(".", "");
        _cpf = _cpf.replace("-", "");
        return _cpf;
    }

    @Override
    public String formatarComPontos(String doc) {

        return (doc.substring(0, 3) + "." + doc.substring(3, 6) + "." + doc.substring(6, 9) + "-" + doc.substring(9, 11) );

    }
}
