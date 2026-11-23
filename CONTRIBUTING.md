# Como trabalhamos no Ninho

Estas são as regras do grupo para o código ficar organizado e a `main` sempre estável.

## Ramos (branches)

| Ramo | Para que serve | Quem escreve nele |
|---|---|---|
| `main` | Versões estáveis. Cada versão ganha uma tag (`v0.1.0`). | Só por pull request vindo da `develop` |
| `develop` | Trabalho da Sprint reunido e testado | Só por pull request |
| `feature/nome` | Uma funcionalidade nova. Ex.: `feature/aba-infos` | Quem desenvolve |
| `fix/nome` | Correção de erro. Ex.: `fix/titulo-da-barra` | Quem corrige |
| `docs/nome` | Documentação. Ex.: `docs/sprint-2` | Quem escreve |
| `hotfix/nome` | Correção urgente de algo que já está na `main` | Quem corrige |

A `main` e a `develop` são **protegidas**: não aceitam `push` direto nem apagar o ramo. Tudo entra por pull request.

## Passo a passo de uma tarefa

1. Atualize a `develop` e crie o seu ramo a partir dela:
   ```
   git switch develop
   git pull origin develop
   git switch -c feature/nome-da-tarefa
   ```
2. Faça as alterações e commits pequenos (um assunto por commit).
3. Envie o ramo:
   ```
   git push -u origin feature/nome-da-tarefa
   ```
4. No GitHub, abra o **pull request** com base na **`develop`** e preencha o modelo.
5. Depois da revisão, use **Squash and merge**. O ramo é apagado sozinho.
6. Atualize o seu computador:
   ```
   git switch develop
   git pull origin develop
   git branch -D feature/nome-da-tarefa
   ```

## Mensagens de commit

Formato: `tipo: descrição curta no presente`.

| Tipo | Quando usar | Exemplo |
|---|---|---|
| `feat` | Funcionalidade nova | `feat: adiciona formulário de Pele` |
| `fix` | Correção de erro | `fix: corrige título da barra no resultado` |
| `docs` | Documentação | `docs: atualiza o README` |
| `style` | Formatação, sem mudar o comportamento | `style: ajusta espaçamento da Home` |
| `refactor` | Reorganiza o código, sem mudar o comportamento | `refactor: separa os dados da Galeria` |
| `test` | Testes | `test: cobre as regras do semáforo` |
| `chore` | Configuração, dependências, tarefas de apoio | `chore: atualiza o Gradle` |

## Pull requests

- Base: `develop` (nunca a `main`, a não ser em uma versão).
- Título no mesmo formato dos commits.
- Preencha o modelo e cite a issue com `Refs #número`. O GitHub só fecha uma issue sozinho quando o pull request vai para a `main`, por isso o `Closes #número` fica para a release.
- Antes de abrir: o projeto compila e foi testado no celular ou no emulador.

## Versões

Usamos [versionamento semântico](https://semver.org/lang/pt-BR/): `vMAIOR.MENOR.CORREÇÃO`.

- `v0.1.0`: MVP da Sprint 1
- `v0.2.0`: Sprint 2
- `v1.0.0`: entrega final

Para lançar uma versão:

1. Atualize o [CHANGELOG.md](CHANGELOG.md) na `develop`.
2. Abra um pull request da `develop` para a `main` e use **Create a merge commit** (não use squash aqui, para os ramos não se separarem).
   Na descrição desse pull request, liste as issues entregues, uma por linha: `Closes #9`, `Closes #12`.
3. Marque a versão e crie a Release no GitHub:
   ```
   git switch main
   git pull origin main
   git tag -a v0.2.0 -m "Descrição da versão"
   git push origin v0.2.0
   ```

## Regras do código

- Linguagem: Java. Textos da interface em português.
- Cores do semáforo (`#2ECC71`, `#F1C40F`, `#E74C3C`) só para o resultado da triagem.
- **Conteúdo clínico:** só muda com a fonte indicada e revisão de alguém da equipe. Nunca invente orientação de saúde.
- Nenhuma IA generativa para emitir resultado: as regras são fixas em código.
- O app não coleta dados pessoais.

## O que nunca vai para o Git

`local.properties`, a pasta `.idea/`, `build/`, arquivos `.apk`, `.aab`, chaves (`.jks`, `.keystore`) e `google-services.json`. Já estão no `.gitignore`. Confira o `git status` antes de cada commit.
