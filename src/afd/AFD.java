package afd;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AFD {
    protected int q = 0;
    protected Set<Integer> Q = new HashSet<>();
    protected Set<Integer> F = new HashSet<>();
    protected Map<Character, Integer> sigma = new HashMap<>();
    protected int[][] table = null;

    public AFD() {

    }

    public AFD(int numStates, String alphabet, int[] endStates, int[][] newTable) throws Exception {
        setSigma(alphabet);
        setQ(numStates);
        setF(endStates);
        table = new int[Q.size()][sigma.size()];
        setTable(newTable);
    }

    private void setTable(int[][] newTable) throws Exception {
        if (newTable.length != Q.size() || newTable[0].length != sigma.size()) {
            throw new Exception("Configuração de tabela de transicao incompativel");
        }

        table = newTable.clone();
    }

    private void setSigma(String symbols) {
        char[] chs = symbols.toCharArray();
        int i = 0;
        for (char c : chs) {
            sigma.put(c, i++);
        }
    }

    private void setF(int[] endStates) throws Exception {
        F.clear();
        for (int endState : endStates) {
            if (!Q.contains(endState)) {
                throw new Exception("Estado Final " + endState + " não pertence ao conjunto Q");
            }

            F.add(endState);
        }
    }

    private void setQ(int numStates) {
        Q.clear();
        for (int i = 0; i < numStates; i++) {
            Q.add(i);
        }
    }

    public boolean run(String w) throws Exception {
        if (table == null) {
            System.out.println("Configurar ('setTable(newTable)')");
        }

        for (int k = 0; k < w.length(); k++) {
            if (!sigma.containsKey(w.charAt(k))) {
                throw new Exception("Simbolo nao pertence ao alfabeto");
            }

            consome(w, k, q);

            if (q >= 0) {
                q = table[q][sigma.get(w.charAt(k))];
            }
        }

        return F.contains(q);
    }

    private void consome(String w, int k, int q) {
        System.out.print(w.substring(0, k));
        System.out.print("[q" + q + "]");
        System.out.println(w.substring(k));
    }
}
