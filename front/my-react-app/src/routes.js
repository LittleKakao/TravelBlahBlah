import React from 'react';
import { Route, Routes } from 'react-router-dom';
import Home from './pages/Home';
import CreateJourney from './pages/CreateJourney';

export default function AppRoutes() {
    return (
        <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/journey/create" element={<CreateJourney />} />
        </Routes>
    );
}