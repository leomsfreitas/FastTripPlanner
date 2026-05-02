# FastTripPlanner

Aplicativo Android para planejamento rápido de viagens, desenvolvido como exercício prático da disciplina de Programação para Dispositivos Móveis.

## Vídeo demonstrativo

[Assista no Google Drive](https://drive.google.com/file/d/1Ln9c7igSUpf0UYHbLZs_rK4wFnoq5ump/view?usp=sharing)

## Objetivo

Integrar os principais conceitos de desenvolvimento Android abordados na disciplina: múltiplas telas, navegação com Intents explícitas e gerenciamento de estado.

## Funcionalidades

### Tela 1 — Dados da Viagem
- Campos de entrada: destino, número de dias e orçamento diário
- Validação dos dados antes de avançar
- Navegação para a próxima tela via Intent explícita

### Tela 2 — Opções da Viagem
- Seleção de tipo de hospedagem (Econômica, Conforto ou Luxo) via RadioButtons
- Seleção de serviços adicionais via Checkboxes: Transporte, Alimentação e Passeios
- Botões **Calcular** (avança para o resumo) e **Voltar**

### Tela 3 — Resumo da Viagem
- Exibição completa de todos os dados inseridos
- Cálculo automático do custo total da viagem
- Botão **Reiniciar Planejamento** para recomeçar do início

## Regras de Cálculo

```
custoBase = dias × orçamentoDiário

Multiplicador de hospedagem:
  Econômica → ×1,0
  Conforto  → ×1,5
  Luxo      → ×2,2

Extras (somados ao custo com multiplicador):
  Transporte  → +R$ 300,00 (fixo)
  Alimentação → +R$ 50,00/dia
  Passeios    → +R$ 120,00/dia

custoTotal = (custoBase × multiplicador) + extras
```

## Requisitos Atendidos

### Funcionais
| ID | Descrição | Status |
|----|-----------|--------|
| RF01 | Inserir dados da viagem | Implementado |
| RF02 | Selecionar opções adicionais | Implementado |
| RF03 | Exibir resumo completo | Implementado |
| RF04 | Navegação via Intents explícitas | Implementado |
| RF05 | Calcular corretamente o custo total | Implementado |

### Não Funcionais
| ID | Descrição | Status |
|----|-----------|--------|
| RNF01 | Compatível com Android 8.0+ (minSdk 26) | Implementado |
| RNF02 | Código organizado e comentado | Implementado |
| RNF03 | Boas práticas (Kotlin, Material3, Compose) | Implementado |
| RNF04 | Entrega com README e vídeo | Implementado |
| RNF05 | Estado preservado na rotação da tela (`rememberSaveable`) | Implementado |

## Tecnologias

- **Linguagem:** Kotlin
- **UI:** Jetpack Compose + Material3
- **Build:** Gradle com Version Catalog (`libs.versions.toml`)
- **minSdk:** 26 (Android 8.0)
- **targetSdk / compileSdk:** 36 (Android 15)

## Estrutura do Projeto

```
app/src/main/java/br/edu/ifsp/scl/sc3045366/fasttripplanner/
├── TripDetailsActivity.kt       # Tela 1: entrada de dados
├── TripOptionsActivity.kt       # Tela 2: opções de hospedagem e serviços
├── TripSummaryActivity.kt       # Tela 3: resumo e custo total
└── ui/
    ├── screens/
    │   ├── TripDetailsScreen.kt  # Composable da Tela 1
    │   ├── TripOptionsScreen.kt  # Composable da Tela 2
    │   └── TripSummaryScreen.kt  # Composable da Tela 3 (inclui lógica de cálculo)
    └── theme/
        └── Theme.kt              # Tema Material3 (claro/escuro)
```