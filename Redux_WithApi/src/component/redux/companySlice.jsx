const url = "http://localhost:8080/api/company";
import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
const companySlice = createSlice({
  name: "company",
  initialState: {
    filterid: "",
    company: [],
  },
  reducers: {
    addcompany: (state, action) => {
      state.company.push(action.payload);
    },
    removecompany: (state, action) => {
      console.log(state.employee);
      state.company = state.company.filter(
        (el) => el.id !== action.payload
      );
    },
    fixcompany: (state, action) => {
      state.company = state.company.map((el) =>
        el.id === parseInt(action.payload.id)
          ? { ...el, name: action.payload.name }
          : el
      );
      console.log(state.company); // In ra state sau khi cập nhật
    },
    changefilter: (state, action) => {
      state.filterid === action.payload
        ? (state.filterid = "")
        : (state.filterid = action.payload);
    },
  },
  extraReducers: (builder) => {
    builder
    // .addCase(ChangeFilter.fulfilled,(state, action) => {
    // })
      .addCase(Fetchcompany.fulfilled, (state, action) => {
        state.company = action.payload;
      })
      .addCase(Addcompany.fulfilled, (state, action) => {
        console.log(action.payload);
        state.company.push(action.payload);
      })
      .addCase(Detelecompany.fulfilled, (state, action) => {
        state.company = state.company.filter(
          (el) => el.id !== action.payload
        );
      })
      .addCase(Fixcompany.fulfilled, (state, action) => {
        state.company = state.company.map((el) =>
          el.id === parseInt(action.payload.id)
            ? { ...el, name: action.payload.name }
            : el
        );
      });
  },
});

export const Fetchcompany = createAsyncThunk(
  "company/Fetchcompany",
  async () => {
    const res = await fetch(`${url}`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      },
    });
    const data = await res.json();
    return data;
  }
);
export const Addcompany = createAsyncThunk(
  "company/Addcompany",
  async (data1) => {
    const res = await fetch(`${url}/create`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data1),
    });
    const data = await res.json();
    return data;
  }
);
export const Detelecompany = createAsyncThunk(
  "company/Detelecompany",
  async (data1)=> {
    //http://localhost:8080/api/company//{truyền
    const res = await fetch(`${url}/deleteall/${data1}`, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data1),
    });
    const data = await res.json();
    
    return data;
  }
);
export const Fixcompany = createAsyncThunk(
  "company/Fixcompany",
  async (data1) => {
    const res = await fetch(`${url}/update/${data1.id}`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        name: data1.name,
        employees: [],
      }),
    });
    const data = await res.json();
    return data;
  }
);

export default companySlice;
