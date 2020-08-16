package dev.ldelelis.devoffchallenge.scytale;

import java.util.ArrayList;
import java.util.List;

public class ScytaleProcessor {
    private String message;
    private Integer turns;

    private List<List<Character>> buildMessageMatrix(int xAxis) {
        List<List<Character>> matrix = new ArrayList<List<Character>>();
        Integer submatrixLength = (int) Math.ceil((float)this.message.length() / this.turns);
        StringBuilder messageBuilder = new StringBuilder();

        // Pre-initialize sub matrices
        for (int i = 0; i < xAxis; i++) {
            matrix.add(new ArrayList<Character>());
        }
        
        // Fill submatrices
        for (int i = 0; i < this.message.length(); i++) {
            char c = this.message.charAt(i);
            Integer matrixIndex = i / submatrixLength;
            List<Character> matrixRow = matrix.get(matrixIndex);
            matrixRow.add(c);
        }

        List<Character> lastRow = matrix.get(matrix.size() - 1);
        Integer padding = submatrixLength - lastRow.size();
        if (padding > 0) {
            for (int i = 0; i < padding; i++) {
                lastRow.add(' ');
            }
        }

        return matrix;
    }

    private char[][] transposeMatrix(List<List<Character>> matrix) {
        Integer outerLength = matrix.size();
        Integer innerLength = matrix.get(0).size();
        char[][] transposedMatrix = new char[innerLength][outerLength];

        for (int i = 0; i < outerLength; i++) {
            for (int j = 0; j < innerLength; j++) {
                transposedMatrix[j][i] = matrix.get(i).get(j);
            }
        }

        return transposedMatrix;
    }

    public ScytaleProcessor(Scytale scytale) {
        this.message = scytale.getMessage();
        this.turns = scytale.getLength();
    }

    public String encrypt() {
        Integer submatrixLength = (int)Math.ceil((float)this.message.length() / this.turns);
        List<List<Character>> matrix = this.buildMessageMatrix(submatrixLength);
        StringBuilder messageBuilder = new StringBuilder();

        char[][] transposed = this.transposeMatrix(matrix);

        for (int i = 0; i < transposed.length; i++) {
            for (int j = 0; j < transposed[i].length; j++) {
                messageBuilder.append(transposed[i][j]);
            }
        }

        return messageBuilder.toString().trim();
    }
    
    public String decrypt() {
        List<List<Character>> matrix = this.buildMessageMatrix(this.turns);
        StringBuilder messageBuilder = new StringBuilder();

        char[][] transposed = this.transposeMatrix(matrix);

        for (int i = 0; i < transposed.length; i++) {
            for (int j = 0; j < transposed[i].length; j++) {
                messageBuilder.append(transposed[i][j]);
            }
        }

        return messageBuilder.toString().trim();
    }
}