#include<stdio.h>
#include<stdlib.h>

struct node
{
	int data;     //Node data
	struct node *nextPtr;    //Address to the next node
};

struct node *firstNode;    //Address of the first node in the linked list 

//Create linked list with specified number of nodes
void createLinkedList(int numberOfNodes);

//Sort the node of the linked list
void sortLinkedList(int numberOfNodes);

//Display Linked List
void displayLinkedList();

int main()
{
	int numberOfNodes;
	
	//Initialize first node of the linked list
	firstNode = NULL;
	
	printf("Input the number of elements in the linked list: ");
	scanf("%d", &numberOfNodes);
	
	createLinkedList(numberOfNodes);
	sortLinkedList(numberOfNodes);
	
	printf("Sorted order is:\n");
	displayLinkedList();
	
	return 0;
}

void createLinkedList(int numberOfNodes)
{
	struct node *newNode;
	struct node *currentNode;
	int nodeData;
	int nodeCtr;
	
	firstNode = (struct node *)malloc(sizeof(struct node));
	
	//Generate a node list if memory was successfully allocated
	if(firstNode == NULL)
	{
		printf("Memory cannot be allocated ");
	}
	else{
		printf("Input the elements in the linked list: \n");
		scanf("%d", &nodeData);
		
		//Save input data to the node
		firstNode->data = nodeData;
		
		//Initialize pointer to the next node to NULL
		firstNode->nextPtr = NULL;
		
		//Copy the address of the first node
		currentNode = firstNode;
		
		//Loop until the specified number of nodes are generated
		for(nodeCtr = 2; nodeCtr <= numberOfNodes; nodeCtr++)
		{
			newNode = (struct node *)malloc(sizeof(struct node));
			
			//Exit function if memory allocation failed
			if(newNode == NULL)
			{
				printf("Memory cannot be allocated");
				break;
			}
			else{
				scanf("%d", &nodeData);
				
				//Save input data to the new node
				newNode->data = nodeData;
				
				//Initialize pointer to the next node to NULL
				newNode->nextPtr = NULL;
				
				//Append to the new node to the last node of the list
				currentNode->nextPtr = newNode;
				
				//Set the new node as the current node
				currentNode = currentNode->nextPtr;
			}
		}
	}
}

void sortLinkedList(int numberOfNodes)
{
	int nodeCtr;
	int ctr;
	int nodeDataCopy;
	struct node *currentNode;
	struct node *nextNode;
	
	//Loop until all the nodes are sorted in increasing order
	for(nodeCtr = numberOfNodes - 2; nodeCtr>=0; nodeCtr--)
	{
		//Point to the first and second node of the linked list
		currentNode = firstNode;
		nextNode = currentNode->nextPtr;
		
		//Loop until the smallest value rises to the loop
		for(ctr = 0; ctr <= nodeCtr; ctr++)
		{
			//Switch the data if current node is larger than the next node
			if(currentNode->data > nextNode->data)
			{
				nodeDataCopy = currentNode->data;
				currentNode->data = nextNode->data;
				nextNode->data = nodeDataCopy;
			}
			
			//Traverse to the next nodes
			currentNode = nextNode;
			nextNode = nextNode->nextPtr;
		}
	}
}

void displayLinkedList()
{
	struct node *currentNode;
	
	//Set the address of the first node
	currentNode = firstNode;
	
	//Loop until all the nodes are traversed
	while(currentNode!=NULL)
	{
		printf("%d\t", currentNode->data);
		
		//Traversed to the next node
		currentNode = currentNode->nextPtr;
	}
}
