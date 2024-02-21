Add a new client:

Endpoint: POST /api/clients
Description: Adds a new client to the system.
Request Body: ClientDTO representing the new client.
Response: Returns the added client information.
Add a new contact for a client (phone or email):

Endpoint: POST /api/clients/{clientId}/contacts
Description: Adds a new contact (phone or email) for the specified client.
Path Variable: clientId - Identifier of the client.
Request Body: ContactDTO representing the new contact.
Response: Returns the added contact information.
Get a list of all clients:

Endpoint: GET /api/clients
Description: Retrieves a list of all clients in the system.
Response: Returns a list of ClientDTOs.
Get information about a specified client by its identifier:

Endpoint: GET /api/clients/{clientId}
Description: Retrieves information about the specified client using its identifier.
Path Variable: clientId - Identifier of the client.
Response: Returns the ClientDTO for the specified client.
Get a list of contacts for a specified client:

Endpoint: GET /api/clients/{clientId}/contacts
Description: Retrieves a list of contacts for the specified client.
Path Variable: clientId - Identifier of the client.
Response: Returns a list of ContactDTOs.
Get a list of contacts of a specified type for a specified client:

Endpoint: GET /api/clients/{clientId}/contacts/{contactType}
Description: Retrieves a list of contacts of the specified type for the specified client.
Path Variables: clientId - Identifier of the client, contactType - Type of the contact (e.g., phone or email).
Response: Returns a list of ContactDTOs.