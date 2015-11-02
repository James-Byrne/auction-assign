#### Distributed Systems Assignment 1

A simple application that simulates an online auction


#### Specification
For this assignment you are required to design and implement a distributed application that is a simulator of an on-line auction system.
There will be multiple clients and a server. The server will offer items for sale. The client module will allow the user to bid for items. An item is sold to the highest bidder. Your code will enable users only to bid for items – it will not conduct actual credit card transactions.
Deliverables: Source code, Design Document, Demo Client Specification
- Connects to the server. The item currently being offered for sale and the current bid or a (or reserve price) are displayed.
- Enter the bid. The amount entered should be greater than the current highest bid.
- After a new bid is placed, the amount of the new bid must be displayed on the client’s window/console.
Server Specification
- Receive connections from multiple clients.
- After a client connects, notify the client which item is currently on sale and the highest bid (or reserve price).
- Specify the bid period. Max allowed 1 minute. When a new bid is raised, the bid period is reset back.
- When a new bid is placed, all clients are notified immediately. Clients should be notified about the time left for bidding (when appropriate).
- If the bid period elapses without a new bid, then the auction for this item closes. The successful bidder (if any) is chosen and all clients are notified.
- When an auction for one item finishes, another item auctioning should start. Minimum of 5 items should be auctioned, one after another. Only one item at a time.
- Any item not sold should be auctioned again (automatically).
