package cholog;

public class SimpleArrayList implements SimpleList {
    private String[] elementData;

    public SimpleArrayList() {
        this.elementData = new String[]{};
    }

    @Override
    public boolean add(String value) {
        int lastIndex = size();
        if (size() == 0) {
            lastIndex = 0;
        }
        add(lastIndex, value);
        return true;
    }

    @Override
    public void add(int index, String value) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException("Index Error");
        }

        String[] values = new String[size()+1];
        for (int i = 0; i < index; i++) {
            values[i] = elementData[i];
        }

        values[index] = value;

        for (int i = index; i < size(); i++) {
            values[i+1] = elementData[i];
        }

        elementData = values;
    }

    @Override
    public String set(int index, String value) {
        return elementData[index] = value;
    }

    @Override
    public String get(int index) {
        return elementData[index];
    }

    @Override
    public boolean contains(String value) {
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(String value) {
        int index = -1;
        for (int i = 0; i < size(); i++) {
            if (value.equals(elementData[i])) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public int size() {
        return elementData.length;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean remove(String value) {
        int index = indexOf(value);
        return value.equals(remove(index));
    }

    @Override
    public String remove(int index) {
        String removeData = elementData[index];

        String[] removedArr = new String[size()-1];
        for (int i = 0; i < index; i++) {
            removedArr[i] = elementData[i];
        }

        for (int i = index; i < size()-1; i++) {
            removedArr[i] = elementData[i+1];
        }

        elementData = removedArr;
        return removeData;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size(); i++) {
            elementData[i] = null;
        }
    }
}
