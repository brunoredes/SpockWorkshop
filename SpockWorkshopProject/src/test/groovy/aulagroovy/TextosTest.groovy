package aulagroovy

import groovy.transform.ToString
import producao.CalculadoraSalario
import spock.lang.Specification

@ToString // cria em tempode execucao o toString da classe
class TextosTest extends Specification {

    def 'deve Ter Strings Iguais'(){
        given:
            def texto1 = 'bom dia, mano'


        when:
            def texto2 = 'bom dia, mano' //'boa tarde, mano'

        then:
            texto1 == texto2
    }

    def 'deve pagar 5% de INSS'(){
        given:
            def calculadora = new CalculadoraSalario()
            def bruto = 800

        when:
            def inss = calculadora.getDescontoInss(bruto)

        then:
            inss == 40.0
    }

    def 'deve pegar o cara certo da lista'(){
        given:
            def lista = null//['abel',null,'mike']

        when:
            def cara = 1

        then:
            lista[cara].toUpperCase() == 'JORGE'
    }

    // data driven tests
    def 'deve calcular o liquido corretamente'(){
        expect:
            liquido == new CalculadoraSalario().getSalarioLiquido(bruto)

        where:
            bruto | liquido
            900   | 855
            1010  | 808
            3500  | 2450
    }

}
