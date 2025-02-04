import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
const url = "http://26.232.136.42:8080/api/employee";
const EmployeeSlice = createSlice({
  name: "employee",
  initialState: {
    filterid:"",
    employee: [],
  },
  reducers: {
    addEmployee: (state, action) => {
      state.employee.push(action.payload);
    },
    removeEmployee: (state, action) => {
      state.employee = state.employee.filter((el) => el.id !== action.payload);
    },
    fixEmployee: (state, action) => {
      state.employee = state.employee.map((el) =>
        el.id === parseInt(action.payload.id)
          ? {
              ...el,
              name: action.payload.name,
              Idcompany: action.payload.Idcompany,
            }
          : el
      );
    },
    changefilter: (state, action) => {
      state.filterid === action.payload
        ? (state.filterid = "")
        : (state.filterid = action.payload);
    },
  },
  extraReducers: (builder) => {
    builder
      .addCase(FetchEmployee.fulfilled, (state, action) => {
        state.employee = action.payload;
        console.log(action.payload);
      })
      .addCase(AddEmployee.fulfilled, (state, action) => {
        state.employee.push(action.payload);
      })
      .addCase(Deteleemployee.fulfilled, (state, action) => {
        state.employee = state.employee.filter(
          (el) => el.id !== action.payload
        );
      })
      .addCase(FixEmployee.fulfilled, (state, action) => {
        state.employee = state.employee.map((el) =>
          el.id === parseInt(action.payload.id)
            ? {
                ...el,
                name: action.payload.name,
                idcompany: action.payload.idcompany,
              }
            : el
        );
      });
  },
});

export const FetchEmployee = createAsyncThunk(
  "employee/FetchEmployee",
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
export const AddEmployee = createAsyncThunk(
  "employee/AddEmployee",
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
export const Deteleemployee = createAsyncThunk(
  "employee/Deteleemployee",
  async (data1, { dispatch }) => {
    const res = await fetch(`${url}/deleteall/${data1}`, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data1),
    });
    const data = await res.json();
    dispatch()
    return data;
  }
);
export const FixEmployee = createAsyncThunk(
  "employee/FixEmployee",
  async (data1) => {
    console.log(data1);
    const res = await fetch(`${url}/update/${data1.id}`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        name: data1.name,
        idcompany: data1.idcompany,
      }),
    });
    const data = await res.json();
    return data;
  }
);
export default EmployeeSlice;
