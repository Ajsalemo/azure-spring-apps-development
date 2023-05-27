import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { Landing } from "../pages/landing/landing"
import { React } from "../pages/react/react"

export const RouteContainer = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" exact Component={Landing} />
        <Route path="/react" Component={React} />
        <Route Component={Landing} />
      </Routes>
    </Router>
  );
};