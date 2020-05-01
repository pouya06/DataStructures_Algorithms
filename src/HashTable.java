public class HashTable<AnyType> {
    private static final int ARRAY_SIZE = 10;

    LinkedList<AnyType>[] hashTable = new LinkedList[ARRAY_SIZE];

    public int computeHashCode(AnyType data) {
        // ascci code of the hash needs to be done
        return data.hashCode();
    }

    public int computeIndex(AnyType data) {
        return computeHashCode(data) % ARRAY_SIZE;
    }

    public void add(AnyType data) {
        int index = computeIndex(data);
        if (hashTable[index] == null) {
            LinkedList<AnyType> linkedList = new LinkedList<>();
            linkedList.addFirst(data);
            hashTable[index] = linkedList;
        } else {
            LinkedList<AnyType> linkedList = hashTable[index];
            linkedList.addFirst(data);
        }
    }

    public boolean contains(AnyType data) {
        int index = computeIndex(data);

        LinkedList<AnyType> linkedList = hashTable[index];

        return linkedList.contains(data);
    }

    public String toString() {
        StringBuffer result = new StringBuffer();
        for(int i = 0 ; i < ARRAY_SIZE ; i++) {
            result.append("index-> " + i + ", values-> " + hashTable[i] + " \n");
        }

        return result.toString();
    }
}
