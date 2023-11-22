import React from 'react';
import '../App.css'; // Import your CSS file for styling

function ServerDownPage() {
    return (
        <div className="server-down-container">
            <div className="server-down-content">
                <h1>Oops!</h1>
                <p>We apologize for the inconvenience. Our server is currently undergoing maintenance.</p>
                <div className="server-down-animation"></div>
                <p>Please check back later.</p>
            </div>
        </div>
    );
}

export { ServerDownPage };
