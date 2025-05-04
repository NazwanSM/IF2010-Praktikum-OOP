public class HTTPRequest {
    private String request;

    /**
     * Constructor untuk request
     * 
     * @param request Request yang akan dikirimkan
     */
    public HTTPRequest(String request) {
        this.request = request;
    }

    public boolean validateRequest() throws InvalidRequestException, InvalidMethodException {
        /*
         * Implementasi dengan aturan:
         * aturan request
         * - Request tidak boleh kosong ("")
         * - Request harus memiliki 2 buah slash (/)
         * - Request hanya bisa mengirimkan HTTP request
         * - Request hanya bisa mengirimkan metode GET, POST, DELETE dan PUT
         * 
         * "GET /url HTTP/1.1" => request yang benar
         * "" => mengembalikkan pesan "Request cannot be empty"
         * "GET url HTTP1.1" => mengembalikan pesan "Request has to have 2 /", hal yang
         * sama berlaku untuk request yang punya 1 slash
         * "GET /url HTP/1.1" => "Can only send HTTP request"
         * "GWT /url HTTP/1.1" => "Method is invalid"
         * 
         * Apabila request mematuhi seluruh aturan, maka request akan mencetak :
         * "Sending <request method> method"
         * request method type disini adalah GET, POST, DELETE atau PUT yang ada pada
         * request
         * 
         * contoh : "GET /url HTTP/1.1" akan mencetak "Sending GET method"
         * 
         * terakhir, apabila request mematuhi seluruh aturan maka ia akan mengembalikkan
         * nilai true
         */

        
        if (request.isEmpty()){
            throw new InvalidRequestException("Request cannot be empty");
        }
        else if (request.indexOf("/") == -1 || request.indexOf("/", request.indexOf("/") + 1) == -1){
            throw new InvalidRequestException("Request has to have 2 /");
        }
        else if(request.indexOf("HTTP") == -1){
            throw new InvalidRequestException("Can only send HTTP request");
        }
        else if (!request.startsWith("GET") && !request.startsWith("POST") && !request.startsWith("DELETE") && !request.startsWith("PUT")) {
            throw new InvalidMethodException();
        }
        else {

            System.out.println("Sending " + request.substring(0, request.indexOf(" ")) + " method");
            return true;
        } 
    }
}

class InvalidRequestException extends Exception {
    public InvalidRequestException(String message) {
        super(message);
    }
}

class InvalidMethodException extends Exception {
    public String getMessage() {
        return "Method is invalid";
    }
}
