import React from 'react';
import { GlobalProvider } from './context/GlobalState';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import './App.css';
import { NotFoundPage } from './components/NotFoundPage';
import {SplitHomePage} from "./components/SplitPage/SplitHomePage";

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
                    <Route path="*" element={<NotFoundPage />} />
                </Routes>
            </BrowserRouter>
        </GlobalProvider>
    );
}

export default App;
