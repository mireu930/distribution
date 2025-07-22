import { Route, Routes } from "react-router-dom"
import List from "../ingredients/list"
import Home from "../home"

export default function AppRouter() {
    return (
        <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/ingredients/list" element={<List/>}></Route>
        </Routes>
    )
}