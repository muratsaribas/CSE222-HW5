import java.util.Random;

public class main {
    public static void main(String[] args){

        
        System.out.println("************************************************************");
        System.out.println("*** Chaining technique for hashing by using linked lists ***");
        System.out.println("************************************************************");
        HashTableChainLinked<Integer, String> linked = new HashTableChainLinked<>(3);

        System.out.println("---------SMALL---------");
        System.out.println("------CAPACITY:3---------");
        System.out.println("Adding items");
        System.out.println("Before adding the '10' to the hash table");
        System.out.println(linked.toString());
        linked.put(10, "ten");
        System.out.println("After adding the '10' to the hash table");
        System.out.println(linked.toString());

        System.out.println("******************************************");
        System.out.println("Before adding the '11' to the hash table");
        System.out.println(linked.toString());
        linked.put(11, "eleven");
        System.out.println("After adding the '11' to the hash table");
        System.out.println(linked.toString());

        System.out.println("******************************************");
        System.out.println("Before adding the '12' to the hash table");
        System.out.println(linked.toString());
        linked.put(12, "twelve");
        System.out.println("After adding the '12' to the hash table");
        System.out.println(linked.toString());

        System.out.println("******************************************");
        System.out.println("Before adding the '13' to the hash table");
        System.out.println(linked.toString());
        linked.put(13, "thirteen");
        System.out.println("After adding the '13' to the hash table");
        System.out.println(linked.toString());

        System.out.println("******************************************");
        System.out.println("Before adding the '14' to the hash table");
        System.out.println(linked.toString());
        linked.put(14, "fourteen");
        System.out.println("After adding the '14' to the hash table");
        System.out.println(linked.toString());

        System.out.println("******************************************");
        System.out.println("Before adding the '15' to the hash table");
        System.out.println(linked.toString());
        linked.put(15, "fifteen");
        System.out.println("After adding the '15' to the hash table");
        System.out.println(linked.toString());

        System.out.println("******************************************");
        System.out.println("Before adding the '18' to the hash table");
        System.out.println(linked.toString());
        linked.put(18, "eighteen");
        System.out.println("After adding the '18' to the hash table");
        System.out.println(linked.toString());

        System.out.println("******************************************");
        System.out.println("Before adding the '21' to the hash table");
        System.out.println(linked.toString());
        linked.put(21, "twenty-one");
        System.out.println("After adding the '21' to the hash table");
        System.out.println(linked.toString());

        System.out.println("******************************************");
        System.out.println("Before adding the '24' to the hash table");
        System.out.println(linked.toString());
        linked.put(24, "twenty-four");
        System.out.println("After adding the '24' to the hash table");
        System.out.println(linked.toString());

        System.out.println("******************************************");
        System.out.println("Before adding the '30' to the hash table");
        System.out.println(linked.toString());
        linked.put(30, "thirty");
        System.out.println("After adding the '30' to the hash table");
        System.out.println(linked.toString());

        System.out.println("******************************************");
        System.out.println("Get the value of the key: 30");
        System.out.println("Value: " + linked.get(30));
        System.out.println("******************************************");
        System.out.println("Get the value of the key: 18");
        System.out.println("Value: " + linked.get(18));
        System.out.println("******************************************");
        System.out.println("Get the value of the key: 28");
        System.out.println("Value: " + linked.get(28));

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Removing items");
        System.out.println("Before removing the '18' from the hash");
        System.out.println(linked.toString());
        System.out.println("Size: "+ linked.size());
        linked.remove(18);
        System.out.println("After removing the '18' from the hash");
        System.out.println(linked.toString());
        System.out.println("Size: "+ linked.size());

        System.out.println("******************************************");
        System.out.println("Before removing the '21' from the hash");
        System.out.println(linked.toString());
        System.out.println("Size: "+ linked.size());
        linked.remove(21);
        System.out.println("After removing the '21' from the hash");
        System.out.println(linked.toString());
        System.out.println("Size: "+ linked.size());

        System.out.println("******************************************");
        System.out.println("Before removing the '14' from the hash");
        System.out.println(linked.toString());
        System.out.println("Size: "+ linked.size());
        linked.remove(14);
        System.out.println("After removing the '14' from the hash");
        System.out.println(linked.toString());
        System.out.println("Size: "+ linked.size());

        System.out.println("******************************************");
        System.out.println("Before removing the '28' from the hash");
        System.out.println(linked.toString());
        System.out.println("Size: "+ linked.size());
        linked.remove(28);
        System.out.println("After removing the '28' from the hash");
        System.out.println(linked.toString());
        System.out.println("Size: "+ linked.size());

        System.out.println("******************************************");
        System.out.println("Get the value of the key: 10");
        System.out.println("Value: " + linked.get(10));

        System.out.println("******************************************");
        System.out.println("After adding '10, ABC' to the hash");
        System.out.println("Get the value of the key: 10");
        linked.put(10, "ABC");
        System.out.println("Value: " +linked.get(10));

        System.out.println("******************************************");
        System.out.println("After adding '10, 15135' to the hash");
        System.out.println("Get the value of the key: 10");
        linked.put(10, "15135");
        System.out.println("Value: " +linked.get(10));

        System.out.println("\n\n--------MEDIUM---------");
        System.out.println("------CAPACITY:10---------");
        HashTableChainLinked<Integer, String> linkedM = new HashTableChainLinked<>(10);

        int[] intArr = new int[50];
        String[] values = new String[50];
        for (int i=0; i < intArr.length; i++){
            Random random = new Random();
            int rand = random.nextInt(500);
            intArr[i] = rand;
            values[i] = Integer.toBinaryString(rand);
        }

        for (int i=0; i<25; i++){
            linkedM.put(intArr[i],values[i]);
        }

        System.out.println("******************************************");
        System.out.println("After adding some items");
        System.out.println(linkedM.toString());

        System.out.println("******************************************");
        System.out.println("Get the value of the key: " + intArr[14]);
        System.out.println("Value: " + linkedM.get(intArr[14]));
        System.out.println("******************************************");
        System.out.println("Get the value of the key: "+ intArr[5]);
        System.out.println("Value: " + linkedM.get(intArr[5]));
        System.out.println("******************************************");
        System.out.println("Get the value of the key: 2587");
        System.out.println("Value: " + linkedM.get(2587));

        System.out.println("******************************************");
        System.out.println("After adding some items(to show the rehash process)");
        System.out.println("Size: " + linkedM.size());
        for (int i=25; i<intArr.length; i++){
            linkedM.put(intArr[i],values[i]);
        }
        System.out.println(linkedM.toString());
        System.out.println("Size: " + linkedM.size());

        System.out.println("******************************************");
        System.out.println("Before removing the key from the hash. Key: " + intArr[4]);
        System.out.println(linkedM.toString());
        System.out.println("Size: "+ linkedM.size());
        linkedM.remove(intArr[4]);
        System.out.println("After removing the key from the hash. Key: "+ intArr[4]);
        System.out.println(linkedM.toString());
        System.out.println("Size: "+ linkedM.size());

        System.out.println("******************************************");
        System.out.println("Before removing the key from the hash. Key: " + intArr[10]);
        System.out.println(linkedM.toString());
        System.out.println("Size: "+ linkedM.size());
        linkedM.remove(intArr[10]);
        System.out.println("After removing the key from the hash. Key: "+ intArr[10]);
        System.out.println(linkedM.toString());
        System.out.println("Size: "+ linkedM.size());

        System.out.println("******************************************");
        System.out.println("Before removing the key from the hash. Key: " + 5999);
        System.out.println(linkedM.toString());
        System.out.println("Size: "+ linkedM.size());
        linkedM.remove(5999);
        System.out.println("After removing the key from the hash. Key: "+ 5999);
        System.out.println(linkedM.toString());
        System.out.println("Size: "+ linkedM.size());

        System.out.println("******************************************");
        System.out.println("Get the value of the key: " + intArr[45]);
        System.out.println("Value: " + linkedM.get(intArr[45]));

        System.out.println("******************************************");
        System.out.println("After adding entry to the hash. Entry: " + intArr[45] +", NEW");
        System.out.println("Get the value of the key: " + intArr[45]);
        linkedM.put(intArr[45], "NEW");
        System.out.println("Value: " +linkedM.get(intArr[45]));

        System.out.println("******************************************");
        System.out.println("After adding entry to the hash. Entry: " + intArr[45] +", QWERTY");
        System.out.println("Get the value of the key: " + intArr[45]);
        linkedM.put(intArr[45], "QWERTY");
        System.out.println("Value: " +linkedM.get(intArr[45]));


        System.out.println("\n\n--------LARGE---------");
        System.out.println("------CAPACITY:101---------");
        HashTableChainLinked<Integer, String> linkedH = new HashTableChainLinked<>();

        for (int i=0; i< intArr.length; i++){
            linkedH.put(intArr[i],values[i]);
        }

        System.out.println("******************************************");
        System.out.println("After adding some items");
        System.out.println(linkedH.toString());

        System.out.println("******************************************");
        System.out.println("Get the value of the key: " + intArr[1]);
        System.out.println("Value: " + linkedH.get(intArr[1]));
        System.out.println("******************************************");
        System.out.println("Get the value of the key: "+ intArr[21]);
        System.out.println("Value: " + linkedH.get(intArr[21]));
        System.out.println("******************************************");
        System.out.println("Get the value of the key: 15963");
        System.out.println("Value: " + linkedH.get(15963));


        System.out.println("******************************************");
        System.out.println("Before removing the key from the hash. Key: " + intArr[1]);
        System.out.println(linkedH.toString());
        System.out.println("Size: "+ linkedH.size());
        linkedH.remove(intArr[1]);
        System.out.println("After removing the key from the hash. Key: "+ intArr[1]);
        System.out.println(linkedH.toString());
        System.out.println("Size: "+ linkedH.size());

        System.out.println("******************************************");
        System.out.println("Before removing the key from the hash. Key: " + intArr[21]);
        System.out.println(linkedH.toString());
        System.out.println("Size: "+ linkedH.size());
        linkedH.remove(intArr[21]);
        System.out.println("After removing the key from the hash. Key: "+ intArr[21]);
        System.out.println(linkedH.toString());
        System.out.println("Size: "+ linkedH.size());

        System.out.println("******************************************");
        System.out.println("Before removing the key from the hash. Key: " + 5999);
        System.out.println(linkedH.toString());
        System.out.println("Size: "+ linkedH.size());
        linkedH.remove(5999);
        System.out.println("After removing the key from the hash. Key: "+ 5999);
        System.out.println(linkedH.toString());
        System.out.println("Size: "+ linkedH.size());

        System.out.println("******************************************");
        System.out.println("Get the value of the key: " + intArr[45]);
        System.out.println("Value: " + linkedH.get(intArr[45]));

        System.out.println("******************************************");
        System.out.println("After adding entry to the hash. Entry: " + intArr[45] +", **NEW**");
        System.out.println("Get the value of the key: " + intArr[45]);
        linkedH.put(intArr[45], "**NEW**");
        System.out.println("Value: " +linkedH.get(intArr[45]));

        System.out.println("******************************************");
        System.out.println("After adding entry to the hash. Entry: " + intArr[45] +", **QWERTY**");
        System.out.println("Get the value of the key: " + intArr[45]);
        linkedH.put(intArr[45], "**QWERTY**");
        System.out.println("Value: " +linkedH.get(intArr[45]));


        System.out.println("************************************************************");
        System.out.println("*** Chaining technique for hashing by using TreeSet ***");
        System.out.println("************************************************************");

        HashTableTreeSet<Integer, String> treeSetS = new HashTableTreeSet<>(3);

        System.out.println("---------SMALL---------");
        System.out.println("------CAPACITY:3---------");
        System.out.println("Adding items");
        System.out.println("Before adding the '10' to the hash table");
        System.out.println(treeSetS.toString());
        treeSetS.put(10, "ten");
        System.out.println("After adding the '10' to the hash table");
        System.out.println(treeSetS.toString());

        System.out.println("******************************************");
        System.out.println("Before adding the '11' to the hash table");
        System.out.println(treeSetS.toString());
        treeSetS.put(11, "eleven");
        System.out.println("After adding the '11' to the hash table");
        System.out.println(treeSetS.toString());

        System.out.println("******************************************");
        System.out.println("Before adding the '12' to the hash table");
        System.out.println(treeSetS.toString());
        treeSetS.put(12, "twelve");
        System.out.println("After adding the '12' to the hash table");
        System.out.println(treeSetS.toString());

        System.out.println("******************************************");
        System.out.println("Before adding the '13' to the hash table");
        System.out.println(treeSetS.toString());
        treeSetS.put(13, "thirteen");
        System.out.println("After adding the '13' to the hash table");
        System.out.println(treeSetS.toString());

        System.out.println("******************************************");
        System.out.println("Before adding the '14' to the hash table");
        System.out.println(treeSetS.toString());
        treeSetS.put(14, "fourteen");
        System.out.println("After adding the '14' to the hash table");
        System.out.println(treeSetS.toString());

        System.out.println("******************************************");
        System.out.println("Before adding the '15' to the hash table");
        System.out.println(treeSetS.toString());
        treeSetS.put(15, "fifteen");
        System.out.println("After adding the '15' to the hash table");
        System.out.println(treeSetS.toString());

        System.out.println("******************************************");
        System.out.println("Before adding the '18' to the hash table");
        System.out.println(treeSetS.toString());
        treeSetS.put(18, "eighteen");
        System.out.println("After adding the '18' to the hash table");
        System.out.println(treeSetS.toString());

        System.out.println("******************************************");
        System.out.println("Before adding the '21' to the hash table");
        System.out.println(treeSetS.toString());
        treeSetS.put(21, "twenty-one");
        System.out.println("After adding the '21' to the hash table");
        System.out.println(treeSetS.toString());

        System.out.println("******************************************");
        System.out.println("Before adding the '24' to the hash table");
        System.out.println(treeSetS.toString());
        treeSetS.put(24, "twenty-four");
        System.out.println("After adding the '24' to the hash table");
        System.out.println(treeSetS.toString());

        System.out.println("******************************************");
        System.out.println("Before adding the '30' to the hash table");
        System.out.println(treeSetS.toString());
        treeSetS.put(30, "thirty");
        System.out.println("After adding the '30' to the hash table");
        System.out.println(treeSetS.toString());

        System.out.println("******************************************");
        System.out.println("Get the value of the key: 30");
        System.out.println("Value: " + treeSetS.get(30));
        System.out.println("******************************************");
        System.out.println("Get the value of the key: 18");
        System.out.println("Value: " + treeSetS.get(18));
        System.out.println("******************************************");
        System.out.println("Get the value of the key: 28");
        System.out.println("Value: " + treeSetS.get(28));

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Removing items");
        System.out.println("Before removing the '18' from the hash");
        System.out.println(treeSetS.toString());
        System.out.println("Size: "+ treeSetS.size());
        treeSetS.remove(18);
        System.out.println("After removing the '18' from the hash");
        System.out.println(treeSetS.toString());
        System.out.println("Size: "+ treeSetS.size());

        System.out.println("******************************************");
        System.out.println("Before removing the '21' from the hash");
        System.out.println(treeSetS.toString());
        System.out.println("Size: "+ treeSetS.size());
        treeSetS.remove(21);
        System.out.println("After removing the '21' from the hash");
        System.out.println(treeSetS.toString());
        System.out.println("Size: "+ treeSetS.size());

        System.out.println("******************************************");
        System.out.println("Before removing the '14' from the hash");
        System.out.println(treeSetS.toString());
        System.out.println("Size: "+ treeSetS.size());
        treeSetS.remove(14);
        System.out.println("After removing the '14' from the hash");
        System.out.println(treeSetS.toString());
        System.out.println("Size: "+ treeSetS.size());

        System.out.println("******************************************");
        System.out.println("Before removing the '28' from the hash");
        System.out.println(treeSetS.toString());
        System.out.println("Size: "+ treeSetS.size());
        treeSetS.remove(28);
        System.out.println("After removing the '28' from the hash");
        System.out.println(treeSetS.toString());
        System.out.println("Size: "+ treeSetS.size());

        System.out.println("******************************************");
        System.out.println("Get the value of the key: 10");
        System.out.println("Value: " + treeSetS.get(10));

        System.out.println("******************************************");
        System.out.println("After adding '10, ABC' to the hash");
        System.out.println("Get the value of the key: 10");
        treeSetS.put(10, "ABC");
        System.out.println("Value: " +treeSetS.get(10));

        System.out.println("******************************************");
        System.out.println("After adding '10, 15135' to the hash");
        System.out.println("Get the value of the key: 10");
        treeSetS.put(10, "15135");
        System.out.println("Value: " +treeSetS.get(10));

        System.out.println("\n\n--------MEDIUM---------");
        System.out.println("------CAPACITY:10---------");
        HashTableTreeSet<Integer, String> treeSetM = new HashTableTreeSet<>(10);

        for (int i=0; i<25; i++){
            treeSetM.put(intArr[i],values[i]);
        }

        System.out.println("******************************************");
        System.out.println("After adding some items");
        System.out.println(treeSetM.toString());

        System.out.println("******************************************");
        System.out.println("Get the value of the key: " + intArr[14]);
        System.out.println("Value: " + treeSetM.get(intArr[14]));
        System.out.println("******************************************");
        System.out.println("Get the value of the key: "+ intArr[5]);
        System.out.println("Value: " + treeSetM.get(intArr[5]));
        System.out.println("******************************************");
        System.out.println("Get the value of the key: 2587");
        System.out.println("Value: " + treeSetM.get(2587));

        System.out.println("******************************************");
        System.out.println("After adding some items(to show the rehash process)");
        System.out.println("Size: " + treeSetM.size());
        for (int i=25; i<intArr.length; i++){
            treeSetM.put(intArr[i],values[i]);
        }
        System.out.println(treeSetM.toString());
        System.out.println("Size: " + treeSetM.size());

        System.out.println("******************************************");
        System.out.println("Before removing the key from the hash. Key: " + intArr[4]);
        System.out.println(treeSetM.toString());
        System.out.println("Size: "+ treeSetM.size());
        treeSetM.remove(intArr[4]);
        System.out.println("After removing the key from the hash. Key: "+ intArr[4]);
        System.out.println(treeSetM.toString());
        System.out.println("Size: "+ treeSetM.size());

        System.out.println("******************************************");
        System.out.println("Before removing the key from the hash. Key: " + intArr[10]);
        System.out.println(treeSetM.toString());
        System.out.println("Size: "+ treeSetM.size());
        treeSetM.remove(intArr[10]);
        System.out.println("After removing the key from the hash. Key: "+ intArr[10]);
        System.out.println(treeSetM.toString());
        System.out.println("Size: "+ treeSetM.size());

        System.out.println("******************************************");
        System.out.println("Before removing the key from the hash. Key: " + 5999);
        System.out.println(treeSetM.toString());
        System.out.println("Size: "+ treeSetM.size());
        treeSetM.remove(5999);
        System.out.println("After removing the key from the hash. Key: "+ 5999);
        System.out.println(treeSetM.toString());
        System.out.println("Size: "+ treeSetM.size());

        System.out.println("******************************************");
        System.out.println("Get the value of the key: " + intArr[45]);
        System.out.println("Value: " + treeSetM.get(intArr[45]));

        System.out.println("******************************************");
        System.out.println("After adding entry to the hash. Entry: " + intArr[45] +", MEDIUM");
        System.out.println("Get the value of the key: " + intArr[45]);
        treeSetM.put(intArr[45], "MEDIUM");
        System.out.println("Value: " +treeSetM.get(intArr[45]));

        System.out.println("******************************************");
        System.out.println("After adding entry to the hash. Entry: " + intArr[45] +", ***MEDIUM***");
        System.out.println("Get the value of the key: " + intArr[45]);
        treeSetM.put(intArr[45], "***MEDIUM***");
        System.out.println("Value: " +treeSetM.get(intArr[45]));

        System.out.println("\n\n--------LARGE---------");
        System.out.println("------CAPACITY:101---------");
        HashTableTreeSet<Integer, String> treeSetL = new HashTableTreeSet<>();

        for (int i=0; i< intArr.length; i++){
            treeSetL.put(intArr[i],values[i]);
        }

        System.out.println("******************************************");
        System.out.println("After adding some items");
        System.out.println(treeSetL.toString());

        System.out.println("******************************************");
        System.out.println("Get the value of the key: " + intArr[1]);
        System.out.println("Value: " + treeSetL.get(intArr[1]));
        System.out.println("******************************************");
        System.out.println("Get the value of the key: "+ intArr[21]);
        System.out.println("Value: " + treeSetL.get(intArr[21]));
        System.out.println("******************************************");
        System.out.println("Get the value of the key: 15963");
        System.out.println("Value: " + treeSetL.get(15963));


        System.out.println("******************************************");
        System.out.println("Before removing the key from the hash. Key: " + intArr[1]);
        System.out.println(treeSetL.toString());
        System.out.println("Size: "+ treeSetL.size());
        treeSetL.remove(intArr[1]);
        System.out.println("After removing the key from the hash. Key: "+ intArr[1]);
        System.out.println(treeSetL.toString());
        System.out.println("Size: "+ treeSetL.size());

        System.out.println("******************************************");
        System.out.println("Before removing the key from the hash. Key: " + intArr[21]);
        System.out.println(treeSetL.toString());
        System.out.println("Size: "+ treeSetL.size());
        treeSetL.remove(intArr[21]);
        System.out.println("After removing the key from the hash. Key: "+ intArr[21]);
        System.out.println(treeSetL.toString());
        System.out.println("Size: "+ treeSetL.size());

        System.out.println("******************************************");
        System.out.println("Before removing the key from the hash. Key: " + 5999);
        System.out.println(treeSetL.toString());
        System.out.println("Size: "+ treeSetL.size());
        treeSetL.remove(5999);
        System.out.println("After removing the key from the hash. Key: "+ 5999);
        System.out.println(treeSetL.toString());
        System.out.println("Size: "+ treeSetL.size());

        System.out.println("******************************************");
        System.out.println("Get the value of the key: " + intArr[45]);
        System.out.println("Value: " + treeSetL.get(intArr[45]));

        System.out.println("******************************************");
        System.out.println("After adding entry to the hash. Entry: " + intArr[45] +", LARGE");
        System.out.println("Get the value of the key: " + intArr[45]);
        treeSetL.put(intArr[45], "LARGE");
        System.out.println("Value: " +treeSetL.get(intArr[45]));

        System.out.println("******************************************");
        System.out.println("After adding entry to the hash. Entry: " + intArr[45] +", **LARGE**");
        System.out.println("Get the value of the key: " + intArr[45]);
        treeSetL.put(intArr[45], "**LARGE**");
        System.out.println("Value: " +treeSetL.get(intArr[45]));

        System.out.println("************************************************************");
        System.out.println("*************** Coalesced hashing technique ****************");
        System.out.println("************************************************************");
        HashTableCoalesced<Integer, String> coalescedS = new HashTableCoalesced<>(3);

        System.out.println("---------SMALL---------");
        System.out.println("------CAPACITY:3---------");
        System.out.println("Adding items");
        System.out.println("Before adding the '10' to the hash table");
        System.out.println(coalescedS.toString());
        coalescedS.put(10, "ten");
        System.out.println("After adding the '10' to the hash table");
        System.out.println(coalescedS.toString());

        System.out.println("******************************************");
        System.out.println("Before adding the '13' to the hash table");
        System.out.println(coalescedS.toString());
        coalescedS.put(13, "thirteen");
        System.out.println("After adding the '13' to the hash table");
        System.out.println(coalescedS.toString());

        System.out.println("******************************************");
        System.out.println("Before adding the '11' to the hash table");
        System.out.println(coalescedS.toString());
        coalescedS.put(11, "eleven");
        System.out.println("After adding the '11' to the hash table");
        System.out.println(coalescedS.toString());

        System.out.println("******************************************");
        System.out.println("Before adding the '17' to the hash table");
        System.out.println(coalescedS.toString());
        coalescedS.put(17, "seventeen");
        System.out.println("After adding the '17' to the hash table");
        System.out.println(coalescedS.toString());

        System.out.println("******************************************");
        System.out.println("Before adding the '24' to the hash table");
        System.out.println(coalescedS.toString());
        coalescedS.put(24, "twenty-four");
        System.out.println("After adding the '24' to the hash table");
        System.out.println(coalescedS.toString());


        System.out.println("******************************************");
        System.out.println("Get the value of the key: 30");
        System.out.println("Value: " + coalescedS.get(10));
        System.out.println("******************************************");
        System.out.println("Get the value of the key: 18");
        System.out.println("Value: " + coalescedS.get(11));
        System.out.println("******************************************");
        System.out.println("Get the value of the key: 28");
        System.out.println("Value: " + coalescedS.get(28));


        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Removing items");
        System.out.println("Before removing the '17' from the hash");
        System.out.println(coalescedS.toString());
        System.out.println("Size: "+ coalescedS.size());
        coalescedS.remove(17);
        System.out.println("After removing the '17' from the hash");
        System.out.println(coalescedS.toString());
        System.out.println("Size: "+ coalescedS.size());

        System.out.println("******************************************");
        System.out.println("Before removing the '24' from the hash");
        System.out.println(coalescedS.toString());
        System.out.println("Size: "+ coalescedS.size());
        coalescedS.remove(24);
        System.out.println("After removing the '24' from the hash");
        System.out.println(coalescedS.toString());
        System.out.println("Size: "+ coalescedS.size());

        System.out.println("******************************************");
        System.out.println("Before removing the '11' from the hash");
        System.out.println(coalescedS.toString());
        System.out.println("Size: "+ coalescedS.size());
        coalescedS.remove(11);
        System.out.println("After removing the '11' from the hash");
        System.out.println(coalescedS.toString());
        System.out.println("Size: "+ coalescedS.size());

        System.out.println("******************************************");
        System.out.println("Before removing the '28' from the hash");
        System.out.println(coalescedS.toString());
        System.out.println("Size: "+ coalescedS.size());
        coalescedS.remove(28);
        System.out.println("After removing the '28' from the hash");
        System.out.println(coalescedS.toString());
        System.out.println("Size: "+ coalescedS.size());

        System.out.println("******************************************");
        System.out.println("Get the value of the key: 10");
        System.out.println("Value: " + coalescedS.get(10));

        System.out.println("******************************************");
        System.out.println("After adding '10, ABC' to the hash");
        System.out.println("Get the value of the key: 10");
        coalescedS.put(10, "ABC");
        System.out.println("Value: " +coalescedS.get(10));

        System.out.println("******************************************");
        System.out.println("After adding '10, 15135' to the hash");
        System.out.println("Get the value of the key: 10");
        coalescedS.put(10, "15135");
        System.out.println("Value: " +coalescedS.get(10));

        System.out.println("\n\n--------MEDIUM---------");
        System.out.println("------CAPACITY:10---------");
        HashTableCoalesced<Integer, String> coalescedM = new HashTableCoalesced<>(10);
        coalescedM.put(3, "three");
        coalescedM.put(12, "twelve");
        coalescedM.put(13, "thirteen");
        coalescedM.put(25, "twenty-five");
        coalescedM.put(23, "twenty-three");
        coalescedM.put(51, "fifty-one");
        coalescedM.put(42, "forty-two");

        System.out.println("******************************************");
        System.out.println("After adding some items");
        System.out.println(coalescedM.toString());

        System.out.println("******************************************");
        System.out.println("Get the value of the key: 3" );
        System.out.println("Value: " + coalescedM.get(3));
        System.out.println("******************************************");
        System.out.println("Get the value of the key: 23");
        System.out.println("Value: " + coalescedM.get(23));
        System.out.println("******************************************");
        System.out.println("Get the value of the key: 2587");
        System.out.println("Value: " + coalescedM.get(2587));


        System.out.println("******************************************");
        System.out.println("Before removing the key from the hash. Key: 13");
        System.out.println(coalescedM.toString());
        System.out.println("Size: "+ coalescedM.size());
        coalescedM.remove(13);
        System.out.println("After removing the key from the hash. Key: 13");
        System.out.println(coalescedM.toString());
        System.out.println("Size: "+ coalescedM.size());

        System.out.println("******************************************");
        System.out.println("Before removing the key from the hash. Key: 99");
        System.out.println(coalescedM.toString());
        System.out.println("Size: "+ coalescedM.size());
        coalescedM.remove(99);
        System.out.println("After removing the key from the hash. Key: 99");
        System.out.println(coalescedM.toString());
        System.out.println("Size: "+ coalescedM.size());

        System.out.println("******************************************");
        System.out.println("Get the value of the key: 23");
        System.out.println("Value: " + coalescedM.get(23));

        System.out.println("******************************************");
        System.out.println("After adding entry to the hash. Entry: 23, MEDIUM");
        System.out.println("Get the value of the key: 23");
        coalescedM.put(23, "MEDIUM");
        System.out.println("Value: " +coalescedM.get(23));

        System.out.println("******************************************");
        System.out.println("After adding entry to the hash. Entry: 23, ***MEDIUM***");
        System.out.println("Get the value of the key: 23");
        coalescedM.put(23, "***MEDIUM***");
        System.out.println("Value: " +coalescedM.get(23));

        System.out.println("\n\n--------LARGE---------");
        System.out.println("------CAPACITY:101---------");
        HashTableCoalesced<Integer, String> coalescedL = new HashTableCoalesced<>();

        for (int i=0; i< intArr.length; i++){
            coalescedL.put(intArr[i],values[i]);
        }

        System.out.println("******************************************");
        System.out.println("After adding some items");
        System.out.println(coalescedL.toString());

        System.out.println("******************************************");
        System.out.println("Get the value of the key: " + intArr[1]);
        System.out.println("Value: " + coalescedL.get(intArr[1]));
        System.out.println("******************************************");
        System.out.println("Get the value of the key: "+ intArr[21]);
        System.out.println("Value: " + coalescedL.get(intArr[21]));
        System.out.println("******************************************");
        System.out.println("Get the value of the key: 15963");
        System.out.println("Value: " + coalescedL.get(15963));


        System.out.println("******************************************");
        System.out.println("Before removing the key from the hash. Key: " + intArr[1]);
        System.out.println(coalescedL.toString());
        System.out.println("Size: "+ treeSetL.size());
        coalescedL.remove(intArr[1]);
        System.out.println("After removing the key from the hash. Key: "+ intArr[1]);
        System.out.println(coalescedL.toString());
        System.out.println("Size: "+ coalescedL.size());

        System.out.println("******************************************");
        System.out.println("Before removing the key from the hash. Key: " + intArr[21]);
        System.out.println(coalescedL.toString());
        System.out.println("Size: "+ coalescedL.size());
        coalescedL.remove(intArr[21]);
        System.out.println("After removing the key from the hash. Key: "+ intArr[21]);
        System.out.println(coalescedL.toString());
        System.out.println("Size: "+ coalescedL.size());

        System.out.println("******************************************");
        System.out.println("Before removing the key from the hash. Key: " + 5999);
        System.out.println(coalescedL.toString());
        System.out.println("Size: "+ coalescedL.size());
        coalescedL.remove(5999);
        System.out.println("After removing the key from the hash. Key: "+ 5999);
        System.out.println(coalescedL.toString());
        System.out.println("Size: "+ coalescedL.size());

        System.out.println("******************************************");
        System.out.println("Get the value of the key: " + intArr[45]);
        System.out.println("Value: " + coalescedL.get(intArr[45]));

        System.out.println("******************************************");
        System.out.println("After adding entry to the hash. Entry: " + intArr[45] +", LARGE");
        System.out.println("Get the value of the key: " + intArr[45]);
        coalescedL.put(intArr[45], "LARGE");
        System.out.println("Value: " +coalescedL.get(intArr[45]));

        System.out.println("******************************************");
        System.out.println("After adding entry to the hash. Entry: " + intArr[45] +", **LARGE**");
        System.out.println("Get the value of the key: " + intArr[45]);
        coalescedL.put(intArr[45], "**LARGE**");
        System.out.println("Value: " +coalescedL.get(intArr[45]));


    }
}
