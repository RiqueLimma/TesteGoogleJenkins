# language: pt
Funcionalidade: Busca no Google

    Cenário: Pesquisar por carros no Google
        Dado que estou na página inicial do Google
        Quando eu digitar "carros" na barra de pesquisa
        E clicar no botão de busca
        Então os resultados da pesquisa devem ser exibidos