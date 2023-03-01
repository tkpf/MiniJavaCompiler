public class Matrix {
    public LinkedVector head;
    public int rows    = 0;
    public int columns = 0;

    public Matrix plus(Matrix other) {
        Matrix result = new Matrix();
        int i = 0;
        while (i < rows) {
            LinkedVector thisRow = this.getRow(i);
            LinkedVector otherRow = other.getRow(i);
            result.addRow(thisRow.plus(otherRow));
            i = i+1;
        }
        return result;
    }

    public Matrix mult(int l) {
        Matrix result = new Matrix();
        int i = 0;
        while (i < rows) {
            LinkedVector thisRow = this.getRow(i);
            result.addRow(thisRow.mult(l));
            i = i+1;
        }
        return result;
    }

    public Matrix mult(Matrix other) {
        Matrix result = new Matrix();
        int i = 0;
        while (i < this.rows) {
            LinkedVector newRow = new LinkedVector();
            LinkedVector thisRow = this.getRow(i);
            int j = 0;
            while (j < other.columns) {
                LinkedVector otherColumn = other.getColumn(j);
                LinkedVector mult = thisRow.mult(otherColumn);
                newRow.add(mult.sum());
                j = j+1;
            }
            result.addRow(newRow);
            i = i+1;
        }
        return result;
    }

    public Matrix transpose() {
        Matrix result = new Matrix();
        int j = 0;
        while (j < this.columns) {
            result.addRow(this.getColumn(j));
            j = j+1;
        }
        return result;
    }

    public void addRow(LinkedVector newRow) {
        int rows = 1;
        if (head == null) {
            head = newRow;
        } else {
            LinkedVector last = head;
            rows = rows + 1;
            while (last.next != null) {
                last = last.next;
                rows = rows + 1;
            }
            last.next = newRow;
        }
        this.rows = rows;
        this.columns = newRow.length;
    }

    public LinkedVector getRow(int pos) {
        LinkedVector pointer = head;
        int i = 0;
        while (i < pos) {
            pointer = pointer.next;
            i = i + 1;
        }
        return pointer;
    }

    public LinkedVector getColumn(int pos) {
        LinkedVector result = new LinkedVector();
        int i = 0;
        while (i < rows) {
            LinkedVector currentRow = getRow(i);
            result.add(currentRow.get(pos));
            i = i+1;
        }
        return result;
    }

    public int getValue(int row, int col) {
        LinkedVector selectRow = getRow(row);
        return selectRow.get(col);
    }

    public void updateValue(int row, int col, int val) {
        LinkedVector selectRow = getRow(row);
        selectRow.update(col, val);
    }

    public boolean equals(Matrix other) {
        if (this.rows != other.rows) {
            return false;
        }
        int i = 0;
        while (i < this.rows) {
            LinkedVector thisRow = this.getRow(i);
            if (!(thisRow.equals(other.getRow(i)))) {
                return false;
            }
            i = i+1;
        }
        return true;
    }
}


class LinkedVector {
    public Node head;
    public LinkedVector next;
    public int length = 0;

    public LinkedVector() {}

    public LinkedVector plus(LinkedVector other) {
        LinkedVector result = new LinkedVector();
        int i = 0;
        while (i < this.length) {
            result.add(this.get(i) + other.get(i));
            i = i+1;
        }
        return result;
    }

    public LinkedVector mult(int l) {
        LinkedVector result = new LinkedVector();
        int i = 0;
        while (i < this.length) {
            result.add(this.get(i) * l);
            i = i+1;
        }
        return result;
    }

    public LinkedVector mult(LinkedVector other) {
        LinkedVector result = new LinkedVector();
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
            while (last.next != null) {
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

    public boolean equals(LinkedVector other) {
        if (this.length != other.length) {
            return false;
        } else {
            int i = 0;
            while (i < this.length) {
                if (this.get(i) != other.get(i)) {
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