Part3 is to create the group chat system using low-level sockets
1. In client folder, there is a “mychat.java” file which create a simple graphical interface for the client to send and receive the chat messages. Then, create an instance of the interface and start the client.
    In the “mychat.java” file, it made a simple event handler for sending a message from the client to the server when the user clicks the send button after typing some text.
2. In server folder, Create a server to listen to clients sending messages and broadcast every received message back to all clients.