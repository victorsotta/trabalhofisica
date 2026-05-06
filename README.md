Projeto de Fisica: 
  Calculadora de Arremesso: 
-Este e um projeto que eu desenvolvi para automatizar os calculos de lancamento obliquo aplicados ao basquete. A ideia principal e descobrir a velocidade exata que a bola precisa ter para cair na cesta, baseando-se no angulo de lancamento e nas distancias da quadra.  O projeto foi baseado nos exercicios manuais que fiz, conforme os rascunhos em PDF, onde resolvi o problema de encontrar a velocidade inicial V0 usando as equacoes de movimento.
  Funcionalidades{
-Interface grafica simples e direta feita com Java Swing.  
-Calculo automatico da velocidade inicial em ft/s pes por segundo.
-Botao de Reset para limpar todos os campos rapidamente.  
-Tratamento de erro para trajetorias fisicamente impossiveis.
}
  Logica do Cálculo:
Para o programa funcionar, usei as formulas de cinematica:
1.  Eixo X: x = V0 * cos(theta) * t.
2.  Eixo Y: y = V0 * sin(theta) * t - 1/2 * g * t^2.
Onde a gravidade g e considerada como 32.17 ft/s^2 para manter o padrao do exercicio original. 
  Layout:
A interface foi montada seguindo o desenho que fiz no papel:
1. Angulo centralizado no topo.  d1 e d2 distancias do jogador e da cesta.
2. h1 e h2 altura do lancamento e da cesta.
3. Botao Calcular bem grande para facilitar o uso.  
  Tecnologias:
-Java JDK 8 ou superior.
-Swing para a interface grafica.

**Autor: Victor F. D. Sota
