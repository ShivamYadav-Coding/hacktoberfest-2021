#include <iostream>
using namespace std;
 
class Node
{
    public:
    int data;
    Node *next;
    
};
 

void push(Node** head_ref, int new_data)
{
    Node* new_node = new Node();
    new_node->data = new_data;
    new_node->next=NULL;
    Node* temp=new Node();
    temp=*head_ref;
    if (*head_ref==NULL){
        *head_ref=new_node;
    }
    else{
        while(temp->next!=NULL){
            temp=temp->next;
        }
        temp->next=new_node;
        
    }
}

void pushAtFirst(Node** head,int new_data){
	Node *new_node=new Node();
	new_node->data=new_data;
	new_node->next=*head;
	*head=new_node;
}

void insertAfter(Node* prev,int d){
	Node* n=new Node();
	n->data=d;
	n->next=NULL;
	if (prev==NULL){
		return;
	}
	else{
		n->next=prev->next;
		prev->next=n;
	}
}
 

void printList(Node *node)
{
    while (node != NULL)
    {
        cout<<" "<<node->data<<"->";
        node = node->next;
    }
    cout<<"NULL";
}
 
/* Driver code*/
int main()
{
    Node* head = NULL;
    cout<<"Initial linked list"<<endl;
    printList(head);
    push(&head, 8);
    push(&head, 9);
    push(&head, 10);
    push(&head, 11);
    push(&head, 12);
    push(&head, 13);
    pushAtFirst(&head,14);
    insertAfter()
     
    cout<<"Created Linked list is: ";
    printList(head);
     
    return 0;
}
