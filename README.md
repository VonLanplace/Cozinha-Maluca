<p align="center">
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="Java Icon" height="40" width="40">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/eclipse/eclipse-original.svg" alt="Eclipse Icon" height="40" width="40">
</p>

# Sistemas Operacionais 1 - Aula 5 - Ex 1

## 🗓️ Aula 5

## 💻 Exercício 1
 
Um servidor com multiprocessamento recebe requisições que envolve realizar cálculos e fazer transações com bancos de dados. 

Por ter uma quantidade grande de núcleos de processamentos e threads, além de um bom algoritmo de escalonamento de threads, enquanto as threads fazem cálculos, estes podem ocorrer simultaneamente, mas quando se faz a transação no banco de dados, esta deve ser apenas uma thread por vez. 

Considere um conjunto de threads com IDs definidas na própria aplicação com números iniciando em 1 e incrementando de um em um. 

### As threads tem comportamento como segue:

**a) Threads com ID dividido por 3 resultando em resto igual a um fazem as transações:**
- Cálculos de 0,2 a 1,0 segundos
- Transação de BD por 1 segundo
- Cálculos de 0,2 a 1,0 segundos
- Transação de BD por 1 segundo

**b) Threads com ID dividido por 3 resultando em resto igual a dois fazem as transações:**
- Cálculos de 0,5 a 1,5 segundos
- Transação de BD por 1,5 segundo
- Cálculos de 0,5 a 1,5 segundos
- Transação de BD por 1,5 segundo
- Cálculos de 0,5 a 1,5 segundos
- Transação de BD por 1,5 segundo

**c) Threads com ID dividido por 3 resultando em resto igual a zero fazem as transações:**
- Cálculos de 1 a 2 segundos
- Transação de BD por 1,5 segundo
- Cálculos de 1 a 2 segundos
- Transação de BD por 1,5 segundo
- Cálculos de 1 a 2 segundos
- Transação de BD por 1,5 segundo

Faça uma aplicação em Java que simule a situação de 21 Threads simultâneas, com exibição em console de cada passo que a Thread está realizando.

---
