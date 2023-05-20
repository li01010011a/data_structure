import java.io.*;
import java.util.*;

class HuffmanEncoder {
    public static void main(String[] args) {
        String inputFile="./result.txt", outputFile="./output.txt";
        encodeFile(inputFile, outputFile);
    }

    private static Map<Character, String> encodeTable;

    public static void encodeFile(String inputFile, String outputFile) {
        try {
            // Step 1: Calculate frequency of each character in the input file
            Map<Character, Integer> frequencyTable = new HashMap<>();
            FileInputStream fileInputStream = new FileInputStream(inputFile);
            int data;
            while ((data = fileInputStream.read()) != -1) {
                char character = (char) data;
                frequencyTable.put(character, frequencyTable.getOrDefault(character, 0) + 1);
            }
            fileInputStream.close();

            // Step 2: Build the Huffman tree
            PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
            for (Map.Entry<Character, Integer> entry : frequencyTable.entrySet()) {
                pq.offer(new HuffmanNode(entry.getValue(), entry.getKey(), null, null));
            }
            while (pq.size() > 1) {
                HuffmanNode left = pq.poll();
                HuffmanNode right = pq.poll();
                HuffmanNode parent = new HuffmanNode(left.frequency + right.frequency, '\0', left, right);
                pq.offer(parent);
            }
            HuffmanNode root = pq.poll();

            // Step 3: Build the encoding table
            encodeTable = new HashMap<>();
            buildEncodeTable(root, "");

            // Step 4: Encode the input file and write to output file
            FileInputStream inputFileStream = new FileInputStream(inputFile);
            BitOutputStream bitOutputStream = new BitOutputStream(new FileOutputStream(outputFile));
            while ((data = inputFileStream.read()) != -1) {
                char character = (char) data;
                String code = encodeTable.get(character);
                bitOutputStream.writeBits(code);
            }
            inputFileStream.close();
            bitOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void buildEncodeTable(HuffmanNode root, String code) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            encodeTable.put(root.data, code);
            return;
        }
        buildEncodeTable(root.left, code + "0");
        buildEncodeTable(root.right, code + "1");
    }
}

class HuffmanNode implements Comparable<HuffmanNode> {
    int frequency;
    char data;
    HuffmanNode left, right;

    public HuffmanNode(int frequency, char data, HuffmanNode left, HuffmanNode right) {
        this.frequency = frequency;
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(HuffmanNode node) {
        return this.frequency - node.frequency;
    }
}

class BitOutputStream {
    private OutputStream outputStream;
    private int buffer;
    private int numBitsInBuffer;

    public BitOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
        buffer = 0;
        numBitsInBuffer = 0;
    }

    public void writeBits(String bits) throws IOException {
        for (char bit : bits.toCharArray()) {
            buffer = (buffer << 1) | (bit - '0');
            numBitsInBuffer++;
            if (numBitsInBuffer == 8) {
                outputStream.write(buffer);
                buffer = 0;
                numBitsInBuffer = 0;
            }
        }
    }

    public void close() throws IOException {
        if (numBitsInBuffer > 0) {
            buffer <<= (8 - numBitsInBuffer);
            outputStream.write(buffer);
        }
        outputStream.close();
    }
}
