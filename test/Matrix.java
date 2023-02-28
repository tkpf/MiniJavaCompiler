public class Matrix {
    public LinkedList head;
    public int rows    = 0;
    public int columns = 0;

    public Matrix plus(Matrix other) {
        Matrix result = new Matrix();
        int i = 0;
        while (i < rows) {
            LinkedList thisRow = this.getRow(i);
            LinkedList otherRow = other.getRow(i);
            result.addRow(thisRow.plus(otherRow));
            i = i+1;
        }
        return result;
    }

    public Matrix mult(int l) {
        Matrix result = new Matrix();
        int i = 0;
        while (i < rows) {
            LinkedList thisRow = this.getRow(i);
            result.addRow(thisRow.mult(l));
            i = i+1;
        }
        return result;
    }

    public Matrix mult(Matrix other) {
        Matrix result = new Matrix();
        int i = 0;
        while (i < this.rows) {
            LinkedList newRow = new LinkedList();
            LinkedList thisRow = this.getRow(i);
            int j = 0;
            while (j < other.columns) {
                LinkedList otherColumn = other.getColumn(j);
                LinkedList mult = thisRow.mult(otherColumn);
                newRow.add(mult.sum());
                j = j+1;
            }
            result.addRow(newRow);
            i = i+1;
        }
        return result;
    }

    public void addRow(LinkedList newRow) {
        int rows = 1;
        if (head == null) {
            head = newRow;
        } else {
            LinkedList last = head;
            rows = rows + 1;
            while (!(last.next == null)) {
                last = last.next;
                rows = rows + 1;
            }
            last.next = newRow;
        }
        this.rows = rows;
        this.columns = newRow.length;
    }

    public LinkedList getRow(int pos) {
        LinkedList pointer = head;
        int i = 0;
        while (i < pos) {
            pointer = pointer.next;
            i = i + 1;
        }
        return pointer;
    }

    public LinkedList getColumn(int pos) {
        LinkedList result = new LinkedList();
        int i = 0;
        while (i < rows) {
            LinkedList currentRow = getRow(i);
            result.add(currentRow.get(pos));
            i = i+1;
        }
        return result;
    }

    public int getValue(int row, int col) {
        LinkedList selectRow = getRow(row);
        return selectRow.get(col);
    }

    public void updateValue(int row, int col, int val) {
        LinkedList selectRow = getRow(row);
        selectRow.update(col, val);
    }

    public boolean equals(Matrix other) {
        if (!(this.rows == other.rows)) {
            return false;
        }
        int i = 0;
        while (i < this.rows) {
            LinkedList thisRow = this.getRow(i);
            if (!(thisRow.equals(other.getRow(i)))) {
                return false;
            }
            i = i+1;
        }
        return true;
    }
}


class LinkedList {
    public Node head;
    public LinkedList next;
    public int length = 0;

    public LinkedList() {}

    public LinkedList plus(LinkedList other) {
        LinkedList result = new LinkedList();
        int i = 0;
        while (i < this.length) {
            result.add(this.get(i) + other.get(i));
            i = i+1;
        }
        return result;
    }

    public LinkedList mult(int l) {
        LinkedList result = new LinkedList();
        int i = 0;
        while (i < this.length) {
            result.add(this.get(i) * l);
            i = i+1;
        }
        return result;
    }

    public LinkedList mult(LinkedList other) {
        LinkedList result = new LinkedList();
        int i = 0;
        while (i < this.length) {
            result.add(this.get(i) * other.get(i));
            i = i+1;
        }
        return result;
    }

    public int sum() {
        int result = 0;
        int i = 0;
        while (i < this.length) {
            result = result + this.get(i);
            i = i+1;
        }
        return result;
    }

    public void add(int i) {
        int length = 1;
        if (head == null) {
            head = new Node(i);
        } else {
            Node last = head;
            length = length + 1;
            while (!(last.next == null)) {
                last = last.next;
                length = length + 1;
            }
            last.next = new Node(i);
        }
        this.length = length;
    }

    public int get(int pos) {
        Node pointer = head;
        int i = 0;
        while (i < pos) {
            pointer = pointer.next;
            i = i + 1;
        }
        return pointer.value;
    }

    public void update(int pos, int value) {
        Node pointer = head;
        int i = 0;
        while (i < pos) {
            pointer = pointer.next;
            i = i + 1;
        }
        pointer.value = value;
    }

    public boolean equals(LinkedList other) {
        if (!(this.length == other.length)) {
            return false;
        } else {
            int i = 0;
            while (i < this.length) {
                if (!(this.get(i) == other.get(i))) {
                    return false;
                }
                i = i+1;
            }
            return true;
        }
    }
}


class Node {
    public int value;
    public Node next;

    public Node(int i) {
        value = i;
    }

    public boolean equals(Node other) {
        return this.value == other.value;
    }
}