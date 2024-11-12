# Juegos en Java: Triqui, Ahorcado y Conecta 4

Este repositorio contiene tres juegos clásicos implementados en Java: **Triqui**, **Ahorcado** y **Conecta 4**. Cada juego está implementado en su respectiva carpeta, y el archivo principal que gestiona la ejecución de estos juegos es **App.java**.

## Archivos del proyecto:

- **App.java**: Archivo principal que enlaza y ejecuta los tres juegos dependiendo de la condición seleccionada.
- **Carpeta "ejercicios"**: Contiene los archivos correspondientes a los tres juegos implementados.
  - **ejercicios/triqui**: Contiene el archivo [Triqui.java](ejercicios/triqui/Triqui.java) que implementa el juego de **Triqui** (Tic-Tac-Toe).
  - **ejercicios/ahorcado**: Contiene el archivo [Ahorcado.java](ejercicios/ahorcado/Ahorcado.java) que implementa el juego del **Ahorcado**.
  - **ejercicios/conecta_4**: Contiene el archivo [Conecta_4.java](ejercicios/conecta_4/Conecta_4.java) que implementa el juego de **Conecta 4**.

---

## 🎮 Triqui

![Tres en línea](https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/Tic_tac_toe.svg/783px-Tic_tac_toe.svg.png)  
_Tomado de [Tres en línea](https://es.wikipedia.org/wiki/Tres_en_l%C3%ADnea) en Wikipedia._

El **Triqui** es un juego de lápiz y papel para dos jugadores, comúnmente conocido como **Tic-Tac-Toe**. El objetivo del juego es marcar tres de tus símbolos (X o O) de manera consecutiva en una fila, columna o diagonal en un tablero de 3x3.

### Reglas:
- Dos jugadores, uno con el símbolo **X** y otro con el símbolo **O**.
- Los jugadores alternan turnos para colocar su símbolo en una casilla vacía.
- El primer jugador en formar una línea horizontal, vertical o diagonal gana.

### Funcionalidades:
- Tablero de 3x3 que se actualiza después de cada movimiento.
- Verificación automática de victoria o empate.
- Alternancia de turnos entre los jugadores.

---

## 🤐 Ahorcado

![Ahorcado](https://upload.wikimedia.org/wikipedia/commons/thumb/6/6e/Hangman.svg/330px-Hangman.svg.png)  
_Tomado de [Ahorcado (juego)](https://es.wikipedia.org/wiki/Ahorcado_(juego)) en Wikipedia._

El **Ahorcado** es un juego en el que un jugador debe adivinar una palabra secreta, letra por letra, antes de que el dibujo del "hombre ahorcado" se complete. Cada vez que adivina una letra incorrecta, una parte del cuerpo del ahorcado se dibuja.

### Reglas:
- El jugador debe adivinar las letras de una palabra secreta.
- Cada error incrementa una parte del dibujo del ahorcado (máximo de 6 fallos).
- El jugador gana si adivina la palabra antes de que se complete el dibujo del ahorcado.

### Funcionalidades:
- Selección aleatoria de palabras secretas.
- Conteo de intentos fallidos y dibujo del ahorcado.
- Verificación de victoria o derrota al adivinar la palabra o llegar al límite de intentos.

---

## 🔴🟡 Conecta 4

![Conecta 4](https://th.bing.com/th/id/OIP.-dva42mI9sPCMuL32up1JgAAAA?rs=1&pid=ImgDetMain)  
_Tomado de [Conecta 4](https://es.wikipedia.org/wiki/Conecta_4) en Wikipedia._

**Conecta 4** es un juego en el que dos jugadores compiten para ser el primero en alinear cuatro fichas de su color en una fila, columna o diagonal en un tablero de 6x7.

### Reglas:
- Los jugadores se turnan para introducir sus fichas en una de las 7 columnas.
- Las fichas caen hasta la fila más baja disponible en esa columna.
- El primer jugador que alinee 4 fichas de manera horizontal, vertical o diagonal gana.

### Funcionalidades:
- Tablero de 6 filas por 7 columnas.
- Verificación de victoria después de cada movimiento.
- Alternancia de turnos entre los jugadores.

---

## 📂 Estructura de Archivos

```plaintext
├── App.java                          # Archivo principal que ejecuta los tres juegos.
├── ejercicios/                        # Carpeta que contiene los juegos.
│   ├── triqui/                         # Carpeta para el juego triqui.
│   │   └── Triqui.java                  # Implementación del juego Triqui.
│   ├── ahorcado/                       # Carpeta para el juego ahorcado.
│   │   └── Ahorcado.java                # Implementación del juego Ahorcado.
│   └── conecta_4/                      # Carpeta para el juego conecta 4.
│       └── Conecta_4.java               # Implementación del juego Conecta 4.
