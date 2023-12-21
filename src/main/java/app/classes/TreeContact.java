package app.classes;

import app.env;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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
            while (true) {
                if (i.getValue().getFullName().toLowerCase().compareTo(baru.getValue().getFullName().toLowerCase()) >= 0) {
                    if (i.getLeftNode() != null) {
                        i = i.getLeftNode();
                    } else {
                        i.setLeftNode(baru);
                        size++;
                        break;
                    }
                } else {
                    if (i.getRightNode() != null) {
                        i = i.getRightNode();
                    } else {
                        i.setRightNode(baru);
                        size++;
                        break;
                    }
                }
            }
        }
    }

    public List<Contact> search(String value) {
        return searchHelper(env.tree.getRoot(), value.toLowerCase());
    }

    private List<Contact> searchHelper(TreeNodeContact node, String value) {
        List<Contact> foundContact = new ArrayList<>();
        if (node != null) {
            if (node.getValue().getFullName().toLowerCase().contains(value)) {
                foundContact.add(node.getValue());
            }
            foundContact.addAll(searchHelper(node.getLeftNode(), value));
            foundContact.addAll(searchHelper(node.getRightNode(), value));
        }
        return foundContact;
    }


    public void inOrder(TreeNodeContact treeNode) {
        if (treeNode == root) {
            env.contactList.clear();
        }
        if (treeNode != null) {
            inOrder(treeNode.getLeftNode());
            env.contactList.add(treeNode.getValue());
            inOrder(treeNode.getRightNode());
        }
    }

    public boolean delete(String value) {
        TreeNodeContact parent = root;
        TreeNodeContact temp = root;
        boolean isLeftChild = false;

        while (!temp.getValue().getFullName().toLowerCase().equals(value.toLowerCase())) {
            parent = temp;
            if (temp.getValue().getFullName().toLowerCase().compareTo(value.toLowerCase()) > 0) {
                isLeftChild = true;
                temp = temp.getLeftNode();
            } else if (temp.getValue().getFullName().toLowerCase().compareTo(value.toLowerCase()) < 0) {
                isLeftChild = false;
                temp = temp.getRightNode();
            }
            if (temp == null) {
                return false;
            }
        }

        if (temp.getLeftNode() == null && temp.getRightNode() == null) {
            if (temp == root) {
                root = null;
            } else if (isLeftChild) {
                parent.setLeftNode(null);
            } else {
                parent.setRightNode(null);
            }
        } else if (temp.getRightNode() == null) {
            if (temp == root) {
                root = temp.getLeftNode();
            } else if (isLeftChild) {
                parent.setLeftNode(temp.getLeftNode());
            } else {
                parent.setRightNode(temp.getLeftNode());
            }
        } else if (temp.getLeftNode() == null) {
            if (temp == root) {
                root = temp.getRightNode();
            } else if (isLeftChild) {
                parent.setLeftNode(temp.getRightNode());
            } else {
                parent.setRightNode(temp.getRightNode());
            }
        } else {
            TreeNodeContact successor = findSuccessor(temp);
            if (temp == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.setLeftNode(successor);
            } else {
                parent.setRightNode(successor);
            }
            successor.setLeftNode(temp.getLeftNode());
        }
        size--;
        return true;
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

