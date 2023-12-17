package app.classes;

import lombok.Data;

@Data
public class TreeContact {

    private TreeNodeContact root;

    public TreeContact() {
        this.root = null;
    }

    public TreeContact(TreeNodeContact root) {
        this.root = root;
    }

    int size;

    public void insertContact(Contact value) {
        if (root == null) {
            root = new TreeNodeContact(value);
            size++;
        } else {
            TreeNodeContact baru = new TreeNodeContact(value);
            TreeNodeContact i = root;
            int index = 0;
            while (true) {
                if (i.getValue().getFullName().charAt(index) >= baru.getValue().getFullName().charAt(index)) {
                    if (i.getLeftNode() != null) i = i.getLeftNode();
                    else {
                        i.setLeftNode(baru);
                        size++;
                        break;
                    }
                } else {
                    if (i.getRightNode() != null) i = i.getRightNode();
                    else {
                        i.setRightNode(baru);
                        size++;
                        break;
                    }
                }
                index++;
            }
        }
    }

    public boolean search(String value) {
        TreeNodeContact i = root;
        int index = 0;
        while (i != null) {
            if (i.getValue().getFullName().equalsIgnoreCase(value)) return true;
            else if (i.getValue().getFullName().charAt(index) > value.charAt(index)) i = i.getRightNode();
            else i = i.getLeftNode();
        }
        return false;
    }

    public boolean delete(String value) {
        TreeNodeContact parent = root;
        TreeNodeContact temp = root;

        int index = 0;
        while (temp != null) {
            if (temp.getValue().getFullName().charAt(index) < value.charAt(index)) {
                parent = temp;
                temp = temp.getRightNode();
            } else if (temp.getValue().getFullName().charAt(index) > value.charAt(index)) {
                parent = temp;
                temp = temp.getLeftNode();
            } else {
                if (temp.getLeftNode() == null && temp.getRightNode() == null) {
                    if (temp == root) {
                        root = null;
                        size--;
                        return true;
                    } else if (parent.getLeftNode() == temp) parent.setLeftNode(null);
                    else parent.setRightNode(null);
                } else if (temp.getLeftNode() == null && temp.getRightNode() != null) {
                    if (temp == root) root = temp.getRightNode();
                    else if (parent.getRightNode() == temp) parent.setRightNode(temp.getRightNode());
                    else parent.setLeftNode(temp.getRightNode());

                } else if (temp.getLeftNode() != null && temp.getRightNode() == null) {
                    if (temp == root) root = temp.getLeftNode();
                    else if (parent.getRightNode() == temp) parent.setRightNode(temp.getLeftNode());
                    else parent.setLeftNode(temp.getLeftNode());
                } else {
                    TreeNodeContact successor = findSuccessor(temp);
                    delete(successor.getValue().getFullName());
                    temp.setValue(successor.getValue());
                    size--;
                }
                size--;
                return true;
            }
            index++;
        }
        return false;
    }

    public TreeNodeContact findSuccessor(TreeNodeContact data) {
        data = data.getRightNode();
        while (data.getLeftNode() != null) {
            data = data.getLeftNode();
        }
        return data;
    }

    public TreeNodeContact findPredecessor(TreeNodeContact data) throws NullPointerException {
        data = data.getLeftNode();
        while (data.getRightNode() != null) {
            data = data.getRightNode();
        }
        return data;
    }

    public TreeNodeContact findMax() {
        TreeNodeContact data = root;
        if (data.getRightNode() == null) return data;
        while (true) {
            if (data.getRightNode() != null) data = data.getRightNode();
            else return data;
        }
    }

    public TreeNodeContact findMin() {
        TreeNodeContact data = root;
        if (data.getLeftNode() == null) return data;
        while (true) {
            if (data.getLeftNode() != null) data = data.getLeftNode();
            else return data;
        }
    }

    public int size() {
        return size;
    }
}

