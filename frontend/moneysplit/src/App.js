import React from 'react';
import { GlobalProvider } from './context/GlobalState';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import './App.css';
import { NotFoundPage } from './components/NotFoundPage';
import {SplitHomePage} from "./components/SplitPage/SplitHomePage";
import {ServerDownPage} from "./components/ServerDownPage";
import {ServerMismatch} from "./components/ServerMismatch";

function App() {
    return (
        <GlobalProvider>
            <BrowserRouter>
                <Routes>
                    <Route
                        path="/split/:splitId" // Define the route parameter using :splitId
                        element={
                            <SplitHomePage/>
                        }
                    />
                    {/* Add route for ServerDownPage */}
                    <Route exact path="/server-down" element={<ServerDownPage/>} />
                    <Route exact path="/outdated" element={<ServerMismatch/>} />
                    <Route path="*" element={<NotFoundPage />} />
                </Routes>
            </BrowserRouter>
        </GlobalProvider>
    );
}

export default App;
