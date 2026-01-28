# Cryptography Challenge – Backend Brasil

Resolução do desafio **Cryptography** proposto pelo repositório [backend-br/desafios](https://github.com/backend-br/desafios/blob/master/cryptography/PROBLEM.md).

## 📌 Descrição do desafio

O objetivo do desafio é implementar um serviço de criptografia capaz de:

* Criptografar um texto utilizando o algoritmo **AES**
* Gerar um **hash SHA-512** do conteúdo original
* Retornar as informações no formato especificado pelo problema

O serviço deve expor uma API que receba os dados de entrada e responda com os valores criptografados e o hash.

## 🧠 Abordagem

A solução foi construída seguindo estritamente os requisitos do desafio:

* Utilização de **AES** para criptografia do texto
* Geração de hash usando **SHA-512**
* Separação clara de responsabilidades (controller, service, crypto utils)
* Código simples, direto e fácil de manter

## 🚀 Tecnologias utilizadas

* Linguagem: **Java 21**
* Framework: **Spring Boot**
* Criptografia: **JASYPT**
* Hash: **SHA-512**

## 📂 Estrutura do projeto

```
.
├── src/
│   ├── controllers/
│   ├── services/
│   └── main
├── tests/
└── README.md
```

## 📎 Referência

Você pode encontrar os detalhes do desafio aqui: https://github.com/backend-br/desafios/blob/master/cryptography/PROBLEM.md