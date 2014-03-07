Sort_Images
===========

java app to sort images according to the parameter

Resumo
===
Este documento descreve as principais características do código Sort images. Este código foi produzido para trabalhar junto com o Image Cloud, com o objetivo de organizar as imagens em ordem crescente ou decrescente segundo algum critério, como frequência de citações, nível de brilho, data de publicação, etc.

Funcionalidade do código
====
O Sort Images tem como objetivo organizar as imagens citadas em um arquivo texto em ordem crescente ou decrescente segundo algum critério numérico. O resultado é salvo em um arquivo chamado IMAGES.txt. Este código foi desenvolvido para trabalhar em conjunto com o Image Cloud, embora seu funcionamento é independente do mesmo.
Compilação e Execução
====
Para compilar o código fonte é necessário ter instalado no computador o Java Development Kit (JDK). Se estiver instalado, coloque o arquivo dentro de uma pasta chamada Sort_image. Abra um terminal (no caso do Linux) ou o DOS (no caso do Windows) ir ao diretório onde está esta pasta e digite:

javac Sort_image\Sort_images.java

Ao executar esse comando são gerados os seguintes arquivos dentro da pasta Sort_image (no caso do Windows):

List_values.class

Sort_images$1.class

Sort_images$2.class

Sort_images.class

Uma vez que o código fonte foi compilado, não é necessário compilar novamente, basta usar os arquivos gerados (mantendo eles sempre dentro de uma pasta com o nome Sort_image) Os arquivos gerados irão rodar em qualquer computador que tenha o ambiente Java instalado.
Para executar um código compilado, basta abrir um terminal ou o DOS e ir ao diretório onde está a Sort_image e executar:

java Sort_image.Sort_images param_1 param_2 param_3 param_4

Os valores de param_1, param_2, param_3 e param_4 são discutidos abaixo. O < e > é só para realçar que são parâmetros de entrada, mas não devem ser inseridos. Perceba que existe um ponto entre Sort_image e Sort_images.
Parâmetros de Entrada
==
O código precisa exatamente de 4 parâmetros de entrada:
java Sort_image.Sort_images param_1 param_2 param_3 param_4

O primeiro parâmetro (param_1) é o nome do arquivo com o nome das imagens e os dados das imagens. É no mesmo formato usado por Plot Polar e pelo image plot do ImageJ. Um exemplo da estrutura desse arquivo é indicado abaixo:

Filename    Year_Month	Brightness_Median	Saturation_Median	Year	Month

001.jpg	1881.834	96	91		1881	11	

002.jpg	1881.834	23	170		1881	11	

003.jpg	1881.834	61	174		1881	11	

004.jpg	1882.5838	240	51		1882	8	

005.jpg	1882.5838	84	57		1882	8	

006.jpg	1882.5838	171	157		1882	8	

007.jpg	1882.5838	86	65		1882	8	

008.jpg	1882.5838	124	130		1882	8

009.jpg	1882.5838	54	117		1882	8

Perceba que a primeira linha é um cabeçalho, e cada coluna é uma informação diferente da imagem.
O segundo parâmetro (param_2) informa em qual coluna do arquivo é informado o nome da imagem. No caso do exemplo anterior é a coluna 1.

O terceiro parâmetro (param_3) informa qual coluna será usada como variável de controle. Se, por exemplo, for usado o brilho médio como variável de controle, então o valor será 3.

O quarto e último parâmetro (param_4) determina a ordem em que as imagens serão organizadas. A letra “a” indica que é de forma ascendente, enquanto a letra “d” indica que é de forma descendente.

Supondo que o nome do arquivo com os dados seja medidas.txt e tenha a estrutura do exemplo, o comando para ordenar as imagens de forma descendente usando o brilho médio é:

java Sort_image.Sort_images medidas.txt 1 3 d

O arquivo medidas.txt deve estar na mesma pasta onde está a pasta Sort_image.
Formato de Saída
====
A saída do código é um arquivo chamado IMAGES.txt. Esse arquivo possui a seguinte estrutura:
9

004.jpg

001.jpg

003.jpg

009.jpg

005.jpg

007.jpg

002.jpg

006.jpg

008.jpg

A primeira linha informa o total de imagens e as outras linhas são os nomes das imagens ordenadas.
Limitações do Código
===
O código não tem tratamento de todas as exceções possíveis, portanto, é necessário informar todos os parâmetros corretamente.
O código ordena baseado em valores numéricos somente.

Contato
===
Dúvidas sobre o código podem ser tiradas com Patrick Marques Ciarelli através do e-mail de contato patrick_cstm@hotmail.com.
