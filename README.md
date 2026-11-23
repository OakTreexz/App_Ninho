# Ninho

**Guia visual e triagem de sinais do recém-nascido.**

Aplicativo Android educativo que ajuda pais e cuidadores a entender sinais comuns do bebê e a decidir se é caso de **ficar em casa**, **procurar a UBS** ou **ir à UPA**.

Projeto da disciplina *Tópicos Avançados em Desenvolvimento de Software* — Ciência da Computação, UNEMAT Cáceres.

> **Aviso:** o Ninho é uma ferramenta educativa. Ele não faz diagnóstico e **não substitui consulta médica**. O conteúdo clínico está em validação por profissional de saúde.

**Versão atual:** [v0.1.0 (MVP)](https://github.com/OakTreexz/App_Ninho/releases/tag/v0.1.0) · [Histórico de mudanças](CHANGELOG.md)

---

## O problema

Muitos pais não conhecem a fisiologia normal do recém-nascido (cor das fezes, icterícia leve, cólicas, coto umbilical). Isso causa medo, idas desnecessárias à unidade de saúde e, às vezes, demora para reconhecer um sinal de alerta.

## Como o app funciona

A pessoa escolhe um assunto, responde a perguntas simples (uma por tela) e recebe o resultado em um semáforo:

| Cor | Significado |
|---|---|
| Verde | Cuidados em casa |
| Amarelo | Atenção: procure a Unidade Básica de Saúde (UBS) |
| Vermelho | Emergência: vá à UPA ou ao Pronto-Socorro |

Se uma resposta indicar sinal de alerta vermelho, o formulário **é interrompido na hora** e o app orienta a procurar a emergência.

As regras são **fixas em código** (sem inteligência artificial) e rodam **no próprio aparelho**: o app não pede cadastro e não envia dados para fora do celular.

## Funcionalidades da versão atual

- Tela de abertura (Splash) com a logo.
- Home com os 6 assuntos: Cocô, Pele e amarelão, Umbigo, Febre e respiração, Choro e cólica, Amamentação e golfadas.
- Barra de navegação inferior: Home, Galeria e Infos.
- Formulário de triagem de cada assunto, com barra de progresso e botão Voltar.
- Pop-up de emergência para respostas de alerta vermelho.
- Tela de resultado verde ou amarela, com orientação por resposta e fonte.
- Galeria: assuntos, fotos de referência do Cocô (ainda como espaços reservados), filtro por cor e tela de detalhe.

## Em desenvolvimento

- Aba Infos (sobre o app, semáforo, fontes e privacidade).
- Aviso legal obrigatório na abertura do app.
- Fotos de referência com licença livre e fotos dos demais assuntos.
- Revisão do conteúdo clínico por profissional de saúde.

## Tecnologias

- Java e Android Studio
- Layouts em XML (Views), Fragments e RecyclerView
- Material Components (Material 3)
- Gradle

## Como executar

1. Instale o [Android Studio](https://developer.android.com/studio).
2. Clone o repositório:
   ```
   git clone https://github.com/OakTreexz/App_Ninho.git
   ```
3. Abra a pasta no Android Studio e aguarde o Gradle sincronizar.
4. Rode o app (▶) em um celular com a **Depuração USB** ligada ou em um emulador. A versão mínima do Android está em `minSdk`, no arquivo `app/build.gradle.kts`.

## Estrutura do projeto

```
app/src/main/
├── java/com/example/app_ninho/
│   ├── SplashActivity, MainActivity            # abertura e navegação inferior
│   ├── HomeFragment, ModuloAdapter, ModuloClinico   # Home e os 6 assuntos
│   ├── Formularios, FormularioCoco, FormularioPele,
│   │   FormularioUmbigo, FormularioFebre,
│   │   FormularioChoro, FormularioAmamentacao  # conteúdo dos formulários
│   ├── Pergunta, Opcao, NivelRisco             # modelo do semáforo
│   ├── TriagemFezesActivity, ResultadoActivity # formulário e resultado
│   └── Galeria, FotoGaleria, Foto*, NivelUi    # aba Galeria
└── res/                                        # layouts, desenhos, cores e textos
docs/                                           # documentação do projeto
```

## Como contribuir

O trabalho segue um fluxo com ramos (`main`, `develop` e `feature/...`) e pull requests. As regras estão em [CONTRIBUTING.md](CONTRIBUTING.md).

## Equipe

**Grupo 3**

- Landara Anne Melo Zinhani (coordenadora)
- Tássia Borges Ferreira (secretária)
- Jonathan Queiroz
- Natália Apaª de J. Carvalho

## Documentação

Documentos de requisitos, Sprints e conteúdo clínico: pasta [`docs/`](docs/).
