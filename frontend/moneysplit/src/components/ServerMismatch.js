import React from 'react';
import '../App.css'; // Import your CSS file for styling

function ServerMismatch() {
    function handleOnClick(){
        console.log(document.url)
        return window.parent.location.href
    }
    return (
        <div className="server-down-container">
            <div className="server-down-content">
                <h1>Oops!</h1>
                <p>We apologize for the inconvenience. You tried updating an expense that has been already modify.</p>
                <p>You are outdated with the server!</p>
                <p>To fix this, please reload the page and re-add your stuff!</p>
                <div className="server-down-animation"></div>
                <button className="btn" onClick={handleOnClick}>
                    reload
                </button>
            </div>
        </div>
    );
}

export { ServerMismatch };
