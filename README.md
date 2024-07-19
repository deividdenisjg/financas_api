# API FINANCEIRA

API para controle de finanças domésticas.

## 🚀 Objetivo

Integrar sistema externo de finanças domésticas a fim de minimizar o trabalho desenvolvendo uma base de dados e regras de négocio.

### 🔧 Tecnologia

Esta API foi desenvolvida na linguegem Java utilizando o framework Spring Boot, onde foi utlizada do ecossitema Spring os starters Spring JPA e SWAGGER com um banco de dados em memória H2.

### 📋 Schemas

###### MovimentoModel
###### {
    id	integer($int64)
    data	string($date-time)
	conta	integer($int32)
	tipo	string
	valor	number($double)
	valorPago	number($double)
###### }
###### ContaModel{
	id	integer($int64)
	nome	string
	descricao	string
###### }
###### SaldoModel
###### {
	saldo	number($double)
###### }

### 📌 ENDPOINTS

[![PUT](https://img.shields.io/badge/PUT-orange.svg)](https://www.boost.org/LICENSE_1_0.txt)
/pagar

[![POST](https://img.shields.io/badge/POST-green.svg)](https://www.boost.org/LICENSE_1_0.txt)
/addMovimento

[![GET](https://img.shields.io/badge/GET-blue.svg)](https://www.boost.org/LICENSE_1_0.txt)
/saldo

[![GET](https://img.shields.io/badge/GET-blue.svg)](https://www.boost.org/LICENSE_1_0.txt)
/aPagar

[![POST](https://img.shields.io/badge/POST-green.svg)](https://www.boost.org/LICENSE_1_0.txt)
/addConta
