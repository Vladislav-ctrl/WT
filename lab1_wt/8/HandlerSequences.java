import java.util.List;

public class HandlerSequences {
    private Sequence sequenceA;
    private Sequence sequenceB;

    public HandlerSequences(Sequence sequenceA, Sequence sequenceB) {
        this.sequenceA = sequenceA;
        this.sequenceB = sequenceB;
    }

    public void elementToSeqA() {
        List<Double> listA = sequenceA.getNumbers();
        List<Double> listB = sequenceB.getNumbers();
        for (int i = 0; i < listB.size(); i++) {
            pasteElement(listA, 0, listA.size() - 1, listB.get(i));
        }
    }

    private void pasteElement(List<Double> list, int left, int right, double element) {
        if (left >= right) {
            if (element > list.get(left)) {
                list.add(left + 1, element);
            } else {
                list.add(left, element);
            }
            return;
        }
        int center = (right + left) / 2;
        if (element > list.get(center)) {
            pasteElement(list, center + 1, right, element);
        } else {
            pasteElement(list, left, center - 1, element);
        }
    }

    public Sequence getSequenceA() {
        return sequenceA;
    }

    public void setSequenceA(Sequence sequenceA) {
        this.sequenceA = sequenceA;
    }

    public Sequence getSequenceB() {
        return sequenceB;
    }

    public void setSequenceB(Sequence sequenceB) {
        this.sequenceB = sequenceB;
    }
}
